package com.manman;

/**
 *
 */
import com.db.Mapper.UserEntity;
import com.db.Mapper.UserMapper;
import com.test.ManmanBean;
import com.test.ManmanPool;
import com.test.pay.UserPay;
import com.test.service.CommonTool;
import com.test.service.StudentService;
import com.test.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class IndexController
{

    @Autowired
    ManmanBean mb;

    @Autowired
    UserMapper userMapper;

    @Autowired
    com.service.UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public void loadIndex(HttpServletResponse resp) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        resp.setHeader("Content-type", "text/html;Charset=utf-8");
        resp.getWriter().write(mb.getName());
//        {
//            //利用注解获取对象
//
//
//            try {
//                resp.getWriter().write("我的名字"+mb.getName()+",年龄:"+mb.getAge());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        {
//            //数据库的连接池
//            try {
//                Class.forName("com.test.ManmanPool");
//                ResultSet result=ManmanPool.pool.createStatement().executeQuery("SELECT * FROM user");
//                while(result.next())
//                {
//                    resp.getWriter().write(result.getString("name"));
//                    resp.getWriter().write("<hr/>");
//                }
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//         }
//        {
        //service包
//            Class<?> cls = Class.forName("com.test.service.StudentService");
//            Object obj=cls.newInstance();
//
//            Method setResponse = cls.getMethod("setResponse",HttpServletResponse.class);
//            setResponse.invoke(obj,resp);
//
//            Method userReg = cls.getMethod("userReg");
//            userReg.invoke(obj);
//
//            try {
//                resp.getWriter().write("<hr/>");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Method userLogin = cls.getMethod("userLogin");
//            userLogin.invoke(obj);

        //spring IOC容器
//            BeanFactory fa=new ClassPathXmlApplicationContext("aopconfig.xml");
//
//            UserService studentservice = (StudentService)fa.getBean("userService");
//            CommonTool com=(CommonTool)fa.getBean("commonTool");
//            com.setResp(resp);
//            studentservice.setResponse(resp);
//            try {
//                studentservice.userLogin();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

//            {
//                //Mybatis,全部查询
//                List<UserEntity> getUser=userMapper.selectAll();
//                for (UserEntity user:getUser)
//                {
//                    resp.getWriter().write(user.getId()+user.getName()+user.getAge());
//                    resp.getWriter().write("<hr/>");
//                }
//            }

//        {
//            //通过指定的Id查询
//            UserEntity userEntity=new UserEntity();
//            userEntity.setId(23);
//            List<UserEntity> getIds=userMapper.selectById(userEntity);
//            for (UserEntity getId:getIds)
//            {
//                resp.getWriter().write(getId.getName());
//            }
//        }
//        {
//            //新增数据
//            UserEntity userEntity=new UserEntity();
//            userEntity.setName("赵qi");
//            userEntity.setPassword("24");
//            userMapper.addUser(userEntity);
//            resp.getWriter().write(String.valueOf(userEntity.getId()));
//        }

//        {
//            //批量新增
//            List<UserEntity> list=new ArrayList<UserEntity>();
//
//            UserEntity userEntity1=new UserEntity();
//            userEntity1.setName("孙琦");
//            userEntity1.setAge(14);
//            list.add(userEntity1);
//
//            UserEntity userEntity2=new UserEntity();
//            userEntity2.setName("袁八");
//            userEntity2.setAge(19);
//            list.add(userEntity2);
//
//            int setSql=userMapper.addUsers(list);
//            resp.getWriter().write(String.valueOf(setSql));
//        }

//        {
//            UserEntity userEntity=new UserEntity();
//            userEntity.setId(83);
//            userEntity.setName("王五");
//            userMapper.ediUser(userEntity);
//        }

//        {
//            //批量更新
//            UserEntity userEntity1=new UserEntity();
//            userEntity1.setId(78);
//
//            UserEntity userEntity2=new UserEntity();
//            userEntity2.setId(79);
//
//            UserEntity userEntity3=new UserEntity();
//            userEntity3.setId(80);
//
//            userMapper.editMuti(new ArrayList<UserEntity>(Arrays.asList(userEntity1,userEntity2,userEntity3)));
//        }

//        {
//            try
//            {
//                userService.AddUser();
//            }
//            catch (Exception ex)
//            {
//                resp.getWriter().write(ex.getMessage());
//            }
//
//        }

//        {
//            //pay
//            //加载配置文件payconfig.xml
//            BeanFactory payFactory=new ClassPathXmlApplicationContext("payconfig.xml");
//            //userpay在配置文件中定义
//            UserPay userpay=(UserPay)payFactory.getBean("userpay");
//            userpay.setResp(resp);
//            userpay.whopay();
//        }

    }
}
