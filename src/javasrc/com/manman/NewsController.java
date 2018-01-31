package com.manman;

import com.Utils.TokenCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class NewsController
{
    @TokenCheck
    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public void getNews(HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-type", "text/html;Charset=utf-8");
        resp.getWriter().write("这里是新闻频道");
    }

    @RequestMapping(value = "/newstest",method = RequestMethod.GET)
    public void getNewstest(HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-type", "text/html;Charset=utf-8");
        resp.getWriter().write("这里是测试新闻频道");
    }
}
