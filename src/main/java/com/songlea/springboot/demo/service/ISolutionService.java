package com.songlea.springboot.demo.service;


import com.songlea.springboot.demo.pojo.Solution;
import com.songlea.springboot.demo.vo.ViewPaperVo;

import java.util.List;

/**
 * Description:
 * Created By xxm
 */
public interface ISolutionService {

    boolean saveSolutionRecord(String userAccount, Integer paperId, List<String> allAnswers);

    List<Solution> findByStatus(String status);

    List<Solution> findAll();

    List<ViewPaperVo> viewStudentChoiceAns(String account, Integer paperId);

    List<ViewPaperVo> viewStudentShortAns(String account, Integer paperId);

    boolean saveMarkingPaper(String account, Integer total, String status);

    List<Solution> findRecords(String account);

}