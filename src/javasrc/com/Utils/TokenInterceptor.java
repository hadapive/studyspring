package com.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor
{
    @Autowired
    JedisPool myJedisPool;

    @Override
    //预处理 在Controller处理前调用，如果该方法返回false，则请求结束
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取GET的token值
        String getToken=httpServletRequest.getParameter("token");
        if(getToken==null)
        {
            httpServletResponse.getWriter().write(" no token");//大家可以改成json形式
            return false;
        }
        Jedis jedis=myJedisPool.getResource();
        String getAppID=jedis.hget("tokenset",getToken);
        if(getAppID!=null && jedis.get(getAppID)!=null && jedis.get(getAppID).toString().trim().equals(getToken.trim()))
        {
            return true;
        }
        else
        {
            httpServletResponse.getWriter().write("error token");
            return false;
        }
    }

    //在Controller调用之后，在DispatcherSevlet进行视图的渲染之前执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
    {


    }

    //在DispatcherSevlet进行视图的渲染之后执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
