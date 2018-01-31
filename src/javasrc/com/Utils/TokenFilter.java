package com.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.*;
import java.io.IOException;

/**
 * web.xml中<filter>拦截到此类进行过滤
 */
public class TokenFilter implements  javax.servlet.Filter {
    @Autowired
    JedisPool myJedisPool;

    //完成Filter的初始化
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //开始过滤的具体内容
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //获取GET的token值
        String getToken=servletRequest.getParameter("token");
        if(getToken==null)
        {
            servletResponse.getWriter().write(" no token");//大家可以改成json形式
            return;
        }
        Jedis jedis=myJedisPool.getResource();
        String getAppID=jedis.hget("tokenset",getToken);
        if(getAppID!=null && jedis.get(getAppID)!=null && jedis.get(getAppID).toString().trim().equals(getToken.trim()))
            filterChain.doFilter(servletRequest, servletResponse);//进入下一步响应 /news
        else
            servletResponse.getWriter().write("error token");

    }

    //Filter销毁前，完成某些资源的回收
    public void destroy() {

    }
}
