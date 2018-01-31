package com.test.pay;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPay
{
    private PayMethod payMethod;
    public PayMethod getPayMethod() {
        return payMethod;
    }
    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }


    private HttpServletResponse resp;
    public HttpServletResponse getResp() {
        return resp;
    }
    public void setResp(HttpServletResponse resp) {
        this.resp = resp;
    }

    public UserPay() {}

    public void whopay()
    {
        try {
            resp.getWriter().write(payMethod.pay());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
