package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.service.IUserService;
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
public class IUserServiceImplTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void checkUser() {
        boolean b = iUserService.checkUser("201512030230", "12345678");
        System.out.println(b);
    }
}