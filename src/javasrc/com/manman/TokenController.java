package com.manman;

/**
 * 验证GET信息并加密
 */

import com.Utils.EncryptUtil;
import com.Utils.WebUtil;
import com.db.Mapper.ClientEntity;
import com.service.ClientService;
import com.service.TokenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class TokenController
{
    @Autowired
    ClientService clientService;
    @Autowired
    JedisPool myJedisPool;

    @RequestMapping(value="/token",method = RequestMethod.GET)
    //@ModelAttribute GET获取得信息转化为ClientEntity类
    //@Valid 要有参数BindingResult bindingResult
    public TokenResult getToken(
            @ModelAttribute @Valid ClientEntity clientEntity,
            BindingResult bindingResult, HttpServletRequest request)
    {

        TokenResult tokenResult=new TokenResult();
        //获取验证注解的message
        if (bindingResult.hasErrors()) {
            //注解的message放入stringBuffer
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                stringBuffer.append(objectError.getDefaultMessage());
            }
            //注入tokenResult
            tokenResult.setAccess_token(stringBuffer.toString());
            tokenResult.setExpires_in("-1");
            //返回json格式
            return tokenResult;
        }

        //GET获取的数据与数据库中的sys_client表数据对比
        if (!clientService.existsClient(clientEntity))
        {
            //比对的信息注入tokenResult
            tokenResult.setAccess_token("客户端不存在");
            tokenResult.setExpires_in("-1");
            return tokenResult;
        }

        String appid=clientEntity.getClient_appid();

        Jedis jedis=myJedisPool.getResource();

        String clientInfo= EncryptUtil.md5(appid
                +clientEntity.getClient_appkey()
                + WebUtil.getIP(request));
        String timeInfo=EncryptUtil.md5(String.valueOf(System.currentTimeMillis()));//md5时间戳
        String tokenString = EncryptUtil.md5(clientInfo + timeInfo);//最终生成的加密串


        if (!jedis.exists(appid))
        {
            jedis.setex(appid, 300, tokenString); //把token放到redis里,设置300秒过期时间
            jedis.hset("tokenset",tokenString,appid);//把token 放入集合，以 token字符串为field
        }

        tokenResult.setAccess_token(jedis.get(appid));
        tokenResult.setExpires_in(String.valueOf(jedis.ttl(appid)));
        return tokenResult;
    }
}
