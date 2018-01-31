package com.test.pay;


public class BankPay implements PayMethod
{
    //private HttpServletResponse resp;


    @Override
    public String pay()
    {
        return "银行卡余额支付";
    }
}
