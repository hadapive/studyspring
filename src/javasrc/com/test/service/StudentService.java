package com.test.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentService implements UserService
{
    private HttpServletResponse resp;
    @Override
    public void setResponse(HttpServletResponse resp)
    {
        this.resp=resp;
    }

    @Override
    public void userReg() throws Exception {
        this.resp.getWriter().write("学生用户注册");
    }

    @Override
    public void userLogin() throws Exception
    {
        this.resp.getWriter().write("学生用户登录");
    }


}
