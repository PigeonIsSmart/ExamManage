package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.service.IProblemService;
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
public class IProblemServiceImplTest {

    @Autowired
    private IProblemService iProblemService;

    @Test
    public void saveProblem() {
        String titile = "选择题";
        String desction = "Agriculture is the country’s chief source of wealth, wheat ____ by far the biggest cereal crop.";
        String ans = "A. is B. been C. be D. being";
        String rightAns = "D";
        String score = "10";
        boolean saveProblem = iProblemService.saveProblem(titile, desction, ans, rightAns, score);
        System.out.println(saveProblem);
    }

    @Test
    public void saveProblem1() {
    }
}