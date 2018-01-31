package com.db.Mapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMapper
{
    //List<UserEntity> selectAll();
    List<UserEntity> selectById(UserEntity userEntity);
    int addUser(UserEntity userEntity);
    int addUsers(List<UserEntity> list);
    int ediUser(UserEntity userEntity);
    int editMuti(List<UserEntity> list);
    int isDistinct(String user_login);
}
