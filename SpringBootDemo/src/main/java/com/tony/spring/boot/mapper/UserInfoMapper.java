package com.tony.spring.boot.mapper;

import com.tony.spring.boot.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKeyWithBLOBs(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}