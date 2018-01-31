package com.db.Mapper;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class ClientEntity
{
    private int client_id;
    private String client_appid;
    private String client_appkey;
    private String client_domain;
    private Date client_regtime;
    private Date client_tokentime;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @NotBlank(message="非空")
    @Pattern(regexp = "^[0-9]{12,30}$",message = "12-30位")
    public String getClient_appid() {
        return client_appid;
    }

    public void setClient_appid(String client_appid) {
        this.client_appid = client_appid;
    }

    @NotBlank(message="非空")
    @Pattern(regexp = "^[0-9a-zA-Z]{15,30}$",message = "15-30位")
    public String getClient_appkey() {
        return client_appkey;
    }

    public void setClient_appkey(String client_appkey) {
        this.client_appkey = client_appkey;
    }

    public String getClient_domain() {
        return client_domain;
    }

    public void setClient_domain(String client_domain) {
        this.client_domain = client_domain;
    }

    public Date getClient_regtime() {
        return client_regtime;
    }

    public void setClient_regtime(Date client_regtime) {
        this.client_regtime = client_regtime;
    }

    public Date getClient_toketime() {
        return client_tokentime;
    }

    public void setClient_toketime(Date client_toketime) {
        this.client_tokentime = client_toketime;
    }
}
