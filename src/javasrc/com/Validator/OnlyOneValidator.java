package com.Validator;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyOneValidator implements ConstraintValidator<OnlyOne,String>
{

    @Autowired
    UserService userService;

    @Override
    public void initialize(OnlyOne onlyOne) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        return userService.UserLoginIsDistinct(s);
    }
}
