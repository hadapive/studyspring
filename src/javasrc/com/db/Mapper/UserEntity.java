package com.db.Mapper;

import com.Validator.OnlyOne;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class UserEntity
{
    private int user_id;
    private String user_login;
    private String user_pwd;
    private String user_regdate;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    //@NotBlank(message = "用户名不能为空!")
    //@Length(min=6,max=20,message = "用户名长度6--20位")
    @Pattern(regexp="^[A-Z]\\w{5,19}$",message = "用户名6-20位，首字母大写")
    @OnlyOne(message = "用户名已经使用")
    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_regdate() {
        return user_regdate;
    }

    public void setUser_regdate(String user_regdate) {
        this.user_regdate = user_regdate;
    }







}
