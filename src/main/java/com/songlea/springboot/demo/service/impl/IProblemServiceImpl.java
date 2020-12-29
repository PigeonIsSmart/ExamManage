package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.common.Constant;
import com.songlea.springboot.demo.dao.ProblemMapper;
import com.songlea.springboot.demo.pojo.Problem;
import com.songlea.springboot.demo.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Created By xxm
 */
@Service
public class IProblemServiceImpl implements IProblemService {

    @Autowired
    private ProblemMapper problemMapper;


    @Override
    public boolean saveProblem(String title, String desction, String ans, String rightAns, String score) {
        Problem problem = new Problem();
        problem.setTitle(title);
        problem.setDesction(desction);
        problem.setAnswer(ans);
        problem.setRightAns(rightAns);
        problem.setScore(Integer.parseInt(score));

        int resCouont = problemMapper.insert(problem);
        return resCouont > 0 ? true : false;
    }

    @Override
    public boolean saveProblem(String title, String desction, String score) {
        Problem problem = new Problem();
        problem.setTitle(title);
        problem.setDesction(desction);
        problem.setScore(Integer.parseInt(score));

        int resCouont = problemMapper.insert(problem);
        return resCouont > 0 ? true : false;
    }

    @Override
    public List<Problem> findAll(String title) {
        List<Problem> allChoices = problemMapper.selectAll(title);
        return allChoices;
    }

}
