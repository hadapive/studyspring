package com.Utils;

/**
 * Token验证类
 *
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TokenCheckClass
{
    @Autowired
    JedisPool myJedisPool;
    public Object exec(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        ServletRequestAttributes atts=(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletResponse response=atts.getResponse();
        HttpServletRequest request=atts.getRequest();
        response.setHeader("Content-type", "text/html;Charset=utf-8");

        //获取拦截前执行的方法,这里是NewsController.java的方法
        MethodSignature methodSignature=(MethodSignature)proceedingJoinPoint.getSignature();
        //判断当前方法是否存在 自定义的注解TokenCheck，参数是注解类
        if (methodSignature.getMethod().isAnnotationPresent(TokenCheck.class))
        {
            //获取GET的token值
            String getToken=request.getParameter("token");
            if(getToken==null)
            {
//                response.getWriter().write(" no token");//大家可以改成json形式
//                return null;
                //抛出错误信息
                throw new Exception(WebUtil.getIP(request)+" no token ");
            }

            //连接redis
            Jedis jedis=myJedisPool.getResource();
            String getAppID=jedis.hget("tokenset",getToken);
            if(getAppID!=null && jedis.get(getAppID)!=null && jedis.get(getAppID).toString().trim().equals(getToken.trim()))
                //继续下一级响应
                return proceedingJoinPoint.proceed();
            else
//                response.getWriter().write("error token");
//                return null;
                //抛出错误信息
                throw new Exception(WebUtil.getIP(request)+" error token ");
        }
        else
        {
            throw new Exception("no-annotation");
            //return proceedingJoinPoint.proceed();
        }


    }
}
