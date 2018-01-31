package com.test;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.ConfigurationNode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@ManmanAnnotation(name="li",age=20)

public class ManmanClass
{
    @ManmanLoad
    com.test.ManmanBean ml;

    @ManmanAnnotation
    com.test.ManmanBean ma;

    public String getName() { return null; }

    @ManmanAnnotation(name="guo")
    public void getMe(HttpServletRequest req, HttpServletResponse resp) throws ConfigurationException, IOException
    {
        //ma = new com.test.ManmanBean();
       // ma.setName("不知道啦");
       // resp.getWriter().write(ma.getName());
//       {
//            resp.setHeader("Content-type","text/html;Charset=utf-8");
//            //req.setAttribute("name","guo");
//            //req.setAttribute("age","18");
//
//            try {
//                //页面跳转
//                req.getRequestDispatcher("/aa.jsp").forward(req,resp);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        {
//            //第三方类库 XMLConfiguration获取配置文件manman.xml的信息
//            //配置文件的路径,注意../，返回上一级目录
//            String config_file=this.getClass().getClassLoader().getResource("").getPath()+"../manman.xml";
//            //resp.getWriter().write(config_file);
//            //第三方类库 XMLConfiguration
//            XMLConfiguration xc=new XMLConfiguration();
//            //加载配置文件
//            xc.load(config_file);
//            //配置文件的根节点
//            ConfigurationNode root=xc.getRootNode();
//            //resp.getWriter().write(root.getName());
//            //获取root的子节点Bean，返回List
//            List<ConfigurationNode> beanlist= root.getChildren("bean");
//            //遍历
//            for (ConfigurationNode n:beanlist)
//            {
//                //resp.getWriter().write(n.getAttribute(1).getValue().toString());
//                //获取bean节点下的p节点
//                List<ConfigurationNode> plist=n.getChildren("p");
//                for (ConfigurationNode p:plist)
//                {
//                    resp.getWriter().write(p.getAttribute(0).getValue().toString()+"="+p.getAttribute(1).getValue().toString());
//                    resp.getWriter().write("<hr/>");
//                }
//            }
//            resp.getWriter().close();
//        }

    }
}

