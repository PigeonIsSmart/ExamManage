package com.songlea.springboot.demo.dao;

import com.songlea.springboot.demo.pojo.Examroom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamroomMapperTest {

    @Autowired
    private ExamroomMapper examroomMapper;

    @Test
    public void selectAll() {
        List<Examroom> examrooms = examroomMapper.selectAll();

        for (Examroom examroom : examrooms) {
            System.out.println(examroom);
        }
    }
}