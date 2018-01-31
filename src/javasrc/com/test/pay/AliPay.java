package com.test.pay;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AliPay implements PayMethod
{
    @Override
    public String pay()
    {
        return "支付宝支付";
    }
}
