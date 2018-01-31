package com.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {OnlyOneValidator.class})
public @interface OnlyOne
{
    String message() default "数据不唯一";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
