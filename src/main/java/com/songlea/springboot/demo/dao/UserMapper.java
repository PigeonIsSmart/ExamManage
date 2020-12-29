package com.songlea.springboot.demo.dao;

import com.songlea.springboot.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    String selectRoleByAccount(String account);

    User selectByAccount(String account);

    int selectAccountAndPasswd(@Param("account") String account,@Param("passwd") String passwd);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}