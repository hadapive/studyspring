package com.test.service;

import javax.servlet.http.HttpServletResponse;

public class CommonTool
{
    private HttpServletResponse resp;

    public void setResp(HttpServletResponse resp)
    {
        this.resp=resp;
    }

    public void addUserLog() throws Exception
    {
        resp.getWriter().write("添加日志文件");
    }

    public void addUserOnline() throws Exception
    {
        resp.getWriter().write("统计在线人数");
    }
}
