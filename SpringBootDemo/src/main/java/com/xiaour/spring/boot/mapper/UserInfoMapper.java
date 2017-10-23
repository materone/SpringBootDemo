package com.xiaour.spring.boot.mapper;

import org.springframework.data.repository.query.Param;

import com.xiaour.spring.boot.entity.UserInfo;

public interface UserInfoMapper {

    UserInfo selectByPrimaryKey(Integer id);
    UserInfo selectByIdNameKey(@Param("id")Integer id, @Param("name")String name);

}