package com.manman;

import com.Utils.ZkUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ZookeeperController
{
    @Autowired
    ZkUtil zkUtil;

    @RequestMapping(value = "/zoo",method = RequestMethod.GET)
    public void zoo(HttpServletRequest rq, HttpServletResponse resp) throws IOException
    {
        //在mvc.xml 设置<bean>
        //超时5000，连接2次,Curator框架,工厂模式
//        CuratorFramework client= CuratorFrameworkFactory.newClient("192.168.1.120:2182,127.0.0.1:2181,192.168.1.107:2183",new RetryNTimes(2,5000));
//        //zookeeper客户端连接
//        client.start();

        String path=rq.getParameter("p");
        try {
            String b = zkUtil.getPathData("/"+path);
            resp.getWriter().write(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        client.close();



    }
}
