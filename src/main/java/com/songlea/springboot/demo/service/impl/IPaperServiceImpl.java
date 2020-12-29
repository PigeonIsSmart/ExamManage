package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.dao.PaperMapper;
import com.songlea.springboot.demo.dao.ProblemMapper;
import com.songlea.springboot.demo.dao.SolutionMapper;
import com.songlea.springboot.demo.pojo.Paper;
import com.songlea.springboot.demo.pojo.Problem;
import com.songlea.springboot.demo.pojo.Solution;
import com.songlea.springboot.demo.service.IPaperService;
import com.songlea.springboot.demo.service.ISolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created By xxm
 */
@Service
public class IPaperServiceImpl implements IPaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private SolutionMapper solutionMapper;

    @Autowired
    private ISolutionService iSolutionService;

    @Override
    public List<Problem> findPaperById(Integer id) {
        Paper paper = paperMapper.selectByPrimaryKey(id);

        List<Problem> paperProblems = new ArrayList<>();

        // 根据试题id获得试题
        if (paper.getChoiceIdList() != null) {
            String[] choices = paper.getChoiceIdList().split(",");
            for (String choiceId : choices) {
                paperProblems.add(problemMapper.selectByPrimaryKey(Integer.parseInt(choiceId)));
            }
        }
        String[] shortAns = paper.getShortAnsIdList().split(",");
        for (String shortAnsId : shortAns) {
            paperProblems.add(problemMapper.selectByPrimaryKey(Integer.parseInt(shortAnsId)));
        }

        return paperProblems;
    }

    @Override
    public String givePaper() {
        Paper randomPaper = givePaperWithRandomProblem();
        // todo 校验
        int resCount = paperMapper.insert(randomPaper);

        // 随机出三套试题
        List<Paper> papers = paperMapper.selectPaperRandomly(3);

        // 返回三套试题id字符串
        StringBuilder paperIdList = new StringBuilder();
        for (int i = 0; i < papers.size(); i++) {
            if (i == papers.size() - 1) {
                paperIdList.append(papers.get(i).getId());
                break;
            }
            paperIdList.append(papers.get(i).getId()).append(",");
        }

        return paperIdList.toString();
    }

    /**
     * 随机出一套试卷的方法
     * 试卷由选择题和填空题组成
     *
     * @return
     */
    private Paper givePaperWithRandomProblem() {
        Paper paper = new Paper();

        // 选择题
        StringBuilder choiceLists = new StringBuilder();
        List<Problem> choiceResList = problemMapper.selectProblemListRandomlyByTitle("选择题", 4);
        for (int i = 0; i < choiceResList.size(); i++) {
            if (i == choiceResList.size() - 1) {
                choiceLists.append(choiceResList.get(i).getId());
                break;
            }
            choiceLists.append(choiceResList.get(i).getId()).append(",");
        }

        // 简答题
        StringBuilder shortAnsLists = new StringBuilder();
        List<Problem> shortAnsResList = problemMapper.selectProblemListRandomlyByTitle("简答题", 2);
        for (int i = 0; i < shortAnsResList.size(); i++) {
            if (i == shortAnsResList.size() - 1) {
                shortAnsLists.append(shortAnsResList.get(i).getId());
                break;
            }
            shortAnsLists.append(shortAnsResList.get(i).getId()).append(",");
        }

        paper.setChoiceIdList(choiceLists.toString());
        paper.setShortAnsIdList(shortAnsLists.toString());
        return paper;
    }


}
