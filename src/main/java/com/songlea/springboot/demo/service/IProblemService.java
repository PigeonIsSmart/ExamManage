package com.songlea.springboot.demo.service;

import com.songlea.springboot.demo.pojo.Problem;

import java.util.List;

/**
 * Description:
 * Created By xxm
 */
public interface IProblemService {

    boolean saveProblem(String title, String desction, String ans, String rightAns, String score);

    boolean saveProblem(String title, String desction, String score);

    List<Problem> findAll(String title);

}
