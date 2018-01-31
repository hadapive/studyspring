package com.service;


import com.db.Mapper.UserEntity;
import com.db.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(rollbackFor = Exception.class)
public class UserService
{
    @Autowired
    UserMapper userMapper;

    //此注解的方法不会触发事务
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public void AddUser() throws Exception {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setName("新用户1");
//        userEntity.setPassword("12");
//
//        userMapper.addUser(userEntity);
//
//        //手动抛出异常,触发回滚
//        //int number=10/0;
//        //throw new RuntimeException("手动抛出运行时异常");
//        //throw new Exception("异常");
//    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<UserEntity> getUserById(int uid)
    {
        UserEntity userEntity=new UserEntity();
        userEntity.setUser_id(uid);
        return userMapper.selectById(userEntity);
    }



    public ServiceResult addUser(UserEntity ue)
    {
        try
        {
            userMapper.addUser(ue);
            return new ServiceResult("成功添加新用户",String.valueOf(ue.getUser_id()));
        } catch(Exception ex)
        {
            return new ServiceResult("失败添加新用户","0");
        }
    }

    public boolean UserLoginIsDistinct(String user_login)
    {
        return userMapper.isDistinct(user_login)>0?false:true;
    }
}
