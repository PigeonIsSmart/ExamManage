package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.dao.PaperMapper;
import com.songlea.springboot.demo.dao.ProblemMapper;
import com.songlea.springboot.demo.pojo.Paper;
import com.songlea.springboot.demo.pojo.Problem;
import com.songlea.springboot.demo.service.IPaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IPaperServiceImplTest {

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private IPaperServiceImpl iPaperService;

    @Test
    public void findPaperById() {
        Paper paper = paperMapper.selectByPrimaryKey(1);

        String[] choices = paper.getChoiceIdList().split(",");
        List<Problem> choiceProblems = new ArrayList<>();
        for (String choiceId : choices) {
            System.out.println(choiceId);
            choiceProblems.add(problemMapper.selectByPrimaryKey(Integer.parseInt(choiceId)));
        }

        List<Problem> shortAnsProblems = new ArrayList<>();
        String[] shortAns = paper.getShortAnsIdList().split(",");
        for (String shortAnsId : shortAns) {
            System.out.println(shortAnsId);
            shortAnsProblems.add(problemMapper.selectByPrimaryKey(Integer.parseInt(shortAnsId)));
        }

        for (Problem choiceProblem : choiceProblems) {
            System.out.println(choiceProblem);
        }

        for (Problem shortAnsProblem : shortAnsProblems) {
            System.out.println(shortAnsProblem);
        }
    }

}