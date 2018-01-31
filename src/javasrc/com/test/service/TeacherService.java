package com.test.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherService implements UserService
{
    private HttpServletResponse resp;

    @Override
    public void setResponse(HttpServletResponse resp)
    {
        this.resp=resp;
    }

    @Override
    public void userReg() throws Exception
    {
        resp.getWriter().write("老师用户注册");
    }

    @Override
    public void userLogin() throws Exception
    {
        resp.getWriter().write("老师用户登录");
    }
}
