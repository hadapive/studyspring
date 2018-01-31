package com.test;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManmanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        //resp.getWriter().write("Hello,This is my Servlet.ManmanServlet");

        resp.setHeader("Content-type", "text/html;Charset=utf-8");

        PrintWriter pw = null;
        try {
            pw = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //可以在jsp文件中<%   %>解析
        //req.setAttribute("name", "wang");
        //req.setAttribute("age", "12");

        //获取地址栏的信息
        String getURI = req.getRequestURI();
        //编辑地址栏的信息
        getURI = getURI.replace("/test/", "");
        //pw.write(getURI);

        //重定向
        //req.getRequestDispatcher("/aa.jsp").forward(req,resp);

        try {
            //通过反射获取的类信息
            Class<?> cls = null;
            try {
                cls = Class.forName("com.test.ManmanClass");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Object obj = null;
            try {
                obj = cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //类的方法
            Method[] mlist = cls.getMethods();
            //类的字段
            Field[] flist=cls.getDeclaredFields();

            //遍历方法
            for (Method m : mlist) {
                //方法中的注解，返回Annotation数组
                Annotation[] anlist = m.getAnnotations();
                for (Annotation a : anlist) {
                    //强制类型转换
                    ManmanAnnotation geta = (ManmanAnnotation) a;
                    //匹配注解
                    if (geta.name().equals(getURI)) {
                        try {
                            m.invoke(obj, new Object[]{req, resp});
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            pw.write("<hr/>");
            //遍历field
            for (Field f:flist)
            {
                Annotation[] fans=f.getAnnotations();
                for (Annotation fan:fans)
                {
                    if (ManmanLoad.class.isInstance(fan))
                    {
                        pw.write(f.getDeclaringClass().getName());
                        pw.write("<hr/>");
                        pw.write(f.getGenericType().getTypeName());
                    }

                }
            }
            pw.close();
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}