package com.manman;


import com.Validator.UserValidator;
import com.db.Mapper.UserEntity;
import com.service.ServiceResult;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;



@RestController
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping(value="/user/{userid}",method=RequestMethod.GET)
    public List<UserEntity> getUser(@PathVariable int userid,HttpServletRequest req)
    {
        //String getId=req.getParameter("id").toString();
        return userService.getUserById(userid);
    }


    //自己写验证必须有，照抄
    //指定当前Controller的validator
//    @InitBinder
//    public void initBinder(DataBinder binder)
//    {
//        binder.setValidator(new UserValidator());
//    }

    //接收json格式的数据，并验证
    @RequestMapping(value="/user",method=RequestMethod.POST)
    //@valid，需要验证的类后面添加参数BindingResult bindingResult
    public ServiceResult addUser(@RequestBody @Valid UserEntity userEntity,BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            StringBuffer stringBuffer=new StringBuffer();
            for (ObjectError objectError:bindingResult.getAllErrors())
            {
                //收集UserValidator.java的错误信息,自定义验证时使用
                //stringBuffer.append(objectError.getCode());

                //使用hihibernate-valiator第三方，获取注解中的信息
              stringBuffer.append(objectError.getDefaultMessage());
            }
            return new ServiceResult("Error",stringBuffer.toString());
        }
        return userService.addUser(userEntity);

    }

}
