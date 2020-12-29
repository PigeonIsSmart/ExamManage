package com.songlea.springboot.demo.dao;

import com.songlea.springboot.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        User user = new User();
        user.setAccount("201512030230");
        user.setPasswd("12345678");
        user.setUserRole("student");
//        int insert = userMapper.insert(user);
        int insert = userMapper.insert(user);
        System.out.println(insert);

    }

    @Test
    public void selectUserByAccountTest(){
        String account = "201512030233";
        User user = userMapper.selectByAccount(account);
        System.out.println(user);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}