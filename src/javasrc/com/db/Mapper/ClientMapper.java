package com.db.Mapper;

import org.springframework.stereotype.Service;

@Service
public interface ClientMapper
{
    public int getClient(ClientEntity clientEntity);
}
