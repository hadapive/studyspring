package com.Validator;


import com.db.Mapper.UserEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 验证类
 * 自定义验证信息
 */


public class UserValidator implements Validator
{

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserEntity.class);
    }

    @Override
    public void validate(Object o, Errors errors)
    {
        UserEntity userEntity=(UserEntity)o;
        if (userEntity.getUser_login()==null || userEntity.getUser_pwd()==null)
        {
            errors.reject("用户名和密码不能为空");
        }
    }
}
