package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.dao.PaperMapper;
import com.songlea.springboot.demo.dao.ProblemMapper;
import com.songlea.springboot.demo.dao.SolutionMapper;
import com.songlea.springboot.demo.pojo.Paper;
import com.songlea.springboot.demo.pojo.Problem;
import com.songlea.springboot.demo.pojo.Solution;
import com.songlea.springboot.demo.service.ISolutionService;
import com.songlea.springboot.demo.vo.ViewPaperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Created By xxm
 */
@Service
public class ISolutionServiceImpl implements ISolutionService {

    @Autowired
    private SolutionMapper solutionMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public boolean saveSolutionRecord(String userAccount, Integer paperId, List<String> allAnswers) {
        // 选择
        StringBuilder choiceRes = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                choiceRes.append(allAnswers.get(i));
                break;
            }
            choiceRes.append(allAnswers.get(i)).append("@");
        }

        // 简答题
        StringBuilder shortAnsRes = new StringBuilder();
        for (int i = 4; i < 6; i++) {
            if (i == 5) {
                shortAnsRes.append(allAnswers.get(i));
                break;
            }
            shortAnsRes.append(allAnswers.get(i)).append("@");
        }

        Solution record = new Solution();
        record.setAccount(userAccount);
        record.setPaperId(paperId);
        record.setChoiceAns(choiceRes.toString());
        record.setShortAnswerAns(shortAnsRes.toString());
        // 未批改试卷为零分
        record.setTotal(0);

        int i = solutionMapper.insert(record);
        return i > 0 ? true : false;
    }

    @Override
    public List<Solution> findByStatus(String status) {
        // 试卷批阅完毕这里没有返回值
        List<Solution> recordsWithOutView = solutionMapper.selectByStatus(status);
        return recordsWithOutView;
    }

    @Override
    public List<Solution> findAll() {
        List<Solution> records = solutionMapper.selectAll();
        return records;
    }

    /**
     * 学生选择题答卷集合
     *
     * @param account
     * @param paperId
     * @return
     */
    @Override
    public List<ViewPaperVo> viewStudentChoiceAns(String account, Integer paperId) {
        // 得到学生答卷
        Solution record = solutionMapper.selectByAccountAndPaperId(account, paperId);
        // 得到试卷 -> 得到试题
        Paper paper = paperMapper.selectByPrimaryKey(paperId);

        List<ViewPaperVo> oneStudentAllAns = new ArrayList<>();

        String[] studentChoiceAns = record.getChoiceAns().split("@");
//        System.out.println(Arrays.toString(studentChoiceAns));
        String[] choiceDescId = paper.getChoiceIdList().split(",");
//        System.out.println(Arrays.toString(choiceDescId));
//        System.out.println(choiceDescId.length);

        for (int i = 0; i < choiceDescId.length; i++) {
            ViewPaperVo markStudent = new ViewPaperVo();
            markStudent.setAccount(account);
            markStudent.setTotal(record.getTotal() + "");
            Problem problem = problemMapper.selectByPrimaryKey(Integer.parseInt(choiceDescId[i]));
            markStudent.setTitle(problem.getTitle());
            markStudent.setDesc(problem.getDesction());
            markStudent.setAns(studentChoiceAns[i]);
            markStudent.setRightAns(problem.getRightAns());

            oneStudentAllAns.add(markStudent);
        }

        return oneStudentAllAns;
    }

    /**
     * 学生简答题答卷集合
     *
     * @param account
     * @param paperId
     * @return
     */
    @Override
    public List<ViewPaperVo> viewStudentShortAns(String account, Integer paperId) {
        // 得到学生答卷
        Solution record = solutionMapper.selectByAccountAndPaperId(account, paperId);
        // 得到试卷 -> 得到试题
        Paper paper = paperMapper.selectByPrimaryKey(paperId);

        List<ViewPaperVo> oneStudentAllAns = new ArrayList<>();

        String[] studentShortAns = record.getShortAnswerAns().split("@");
        String[] shortAnsDescId = paper.getShortAnsIdList().split(",");

        for (int i = 0; i < shortAnsDescId.length; i++) {
            ViewPaperVo markStudent = new ViewPaperVo();
            markStudent.setAccount(account);
            markStudent.setTotal(record.getTotal() + "");
            Problem problem = problemMapper.selectByPrimaryKey(Integer.parseInt(shortAnsDescId[i]));
            markStudent.setTitle(problem.getTitle());
            markStudent.setDesc(problem.getDesction());
            markStudent.setAns(studentShortAns[i]);

            oneStudentAllAns.add(markStudent);
        }

        return oneStudentAllAns;
    }

    /**
     * 保存批阅结果
     *
     * @param account
     * @param total
     * @param status
     * @return
     */
    @Override
    public boolean saveMarkingPaper(String account, Integer total, String status) {
        Solution solution = new Solution();
        solution.setAccount(account);
        solution.setTotal(total);
        solution.setStatus(status);

        int i = solutionMapper.updateTotalAndStatusByAccount(solution);
        return i > 0 ? true : false;
    }

    @Override
    public List<Solution> findRecords(String account) {
        List<Solution> records = solutionMapper.selectByAccount(account);
        return records;
    }

}