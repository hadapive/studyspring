package com.service;

public class TokenResult
{
    private String Access_token;
    private String Expires_in;

    public String getAccess_token() {
        return Access_token;
    }

    public void setAccess_token(String access_token) {
        Access_token = access_token;
    }

    public String getExpires_in() {
        return Expires_in;
    }

    public void setExpires_in(String expires_in) {
        Expires_in = expires_in;
    }
}
