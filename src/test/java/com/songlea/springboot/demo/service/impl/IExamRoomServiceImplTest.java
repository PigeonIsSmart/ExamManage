package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.pojo.Examroom;
import com.songlea.springboot.demo.service.IExamRoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IExamRoomServiceImplTest {

    @Autowired
    private IExamRoomService iExamRoomService;

    @Test
    public void findAll() {
        List<Examroom> all = iExamRoomService.findAll();
        for (Examroom examroom : all) {
            System.out.println(examroom);
        }
    }
}