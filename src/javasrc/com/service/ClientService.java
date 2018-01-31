package com.service;

import com.db.Mapper.ClientEntity;
import com.db.Mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientService
{
    @Autowired
    ClientMapper clientMapper;

    public boolean existsClient(ClientEntity clientEntity)
    {
//        ClientEntity clientEntity=new ClientEntity();
//        clientEntity.setClient_appid(appid);
//        clientEntity.setClient_appkey(appkey);
        if (clientMapper.getClient(clientEntity)==1)
        {
            return true;
        }
        return false;
    }
}
