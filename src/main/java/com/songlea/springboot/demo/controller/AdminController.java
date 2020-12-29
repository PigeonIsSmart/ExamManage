package com.songlea.springboot.demo.controller;

import com.songlea.springboot.demo.common.Constant;
import com.songlea.springboot.demo.dao.SolutionMapper;
import com.songlea.springboot.demo.pojo.Problem;
import com.songlea.springboot.demo.pojo.Solution;
import com.songlea.springboot.demo.service.IProblemService;
import com.songlea.springboot.demo.service.ISolutionService;
import com.songlea.springboot.demo.vo.ViewPaperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Description:
 * Created By xxm
 */
@Controller
public class AdminController {

    @Autowired
    private IProblemService iProblemService;

    @Autowired
    private ISolutionService iSolutionService;

    /**
     * 新增选择题
     *
     * @param title
     * @param desction
     * @param ans
     * @param rightAns
     * @param score
     * @return
     */
    @RequestMapping("/savechoice")
    public String saveProblem(@RequestParam("title") String title,
                              @RequestParam("desction") String desction,
                              @RequestParam("ans") String ans,
                              @RequestParam("rightAns") String rightAns,
                              @RequestParam("score") String score,
                              Model model) {
        boolean save = iProblemService.saveProblem(title, desction, ans, rightAns, score);
        if (!save) {
            model.addAttribute(Constant.MESSAGE, "新增选择题失败");
            return "back/index";
        }
        model.addAttribute(Constant.MESSAGE, "新增选择题成功");
        return "back/index";
    }

    /**
     * 出简答题
     *
     * @param title
     * @param desction
     * @param score
     * @return
     */
    @RequestMapping("/saveshortans")
    public String saveProblem(@RequestParam("title") String title,
                              @RequestParam("desction") String desction,
                              @RequestParam("score") String score,
                              Model model) {

        boolean save = iProblemService.saveProblem(title, desction, score);
        if (!save) {
            model.addAttribute(Constant.MESSAGE, "新增简答题失败");
            return "back/index";
        }
        model.addAttribute(Constant.MESSAGE, "新增简答题成功");
        return "back/index";
    }

    /**
     * 查看选择题
     *
     * @param model
     * @return
     */
    @RequestMapping("/viewchoice")
    public String viewChoice(Model model) {
        List<Problem> allChoice = iProblemService.findAll(Constant.CHOICE);
        model.addAttribute(Constant.CHOICELIST, allChoice);
        return "back/viewchoice";
    }

    /**
     * 查看简答题
     *
     * @param model
     * @return
     */
    @RequestMapping("/viewshortans")
    public String viewShortAns(Model model) {
        List<Problem> allChoice = iProblemService.findAll(Constant.SHORTANS);
        model.addAttribute(Constant.SHORTANSLIST, allChoice);
        return "back/viewshortans";
    }

    /**
     * 查看试卷状态
     *
     * @param model
     * @return
     */
    @RequestMapping("/viewsolution")
    public String viewSolutions(Model model) {
        // todo 这里不需要答案
        List<Solution> records = iSolutionService.findAll();
        model.addAttribute("records", records);
        return "back/solutions";
    }

    /**
     * 阅卷
     *
     * @return
     */
    @RequestMapping("/dopaper")
    public String doPaper(@RequestParam("account") String account,
                          @RequestParam("paperId") Integer paperId,
                          Model model) {
        List<ViewPaperVo> viewChoiceVos = iSolutionService.viewStudentChoiceAns(account, paperId);
        List<ViewPaperVo> viewShortAnsVos = iSolutionService.viewStudentShortAns(account, paperId);

        model.addAttribute(Constant.CHOICELIST, viewChoiceVos);
        model.addAttribute(Constant.SHORTANSLIST, viewShortAnsVos);

        return "back/dopaper";
    }

    /**
     * 保存批阅结果
     *
     * @return
     */
    @RequestMapping("/savemark")
    public String saveMarkPaper(@RequestParam("account") String account,
                                @RequestParam("total") Integer total,
                                @RequestParam("status") String status,
                                Model model) {
        boolean b = iSolutionService.saveMarkingPaper(account, total, status);
        if (!b) {
            model.addAttribute(Constant.MESSAGE, "批阅失败");
            return "back/index";
        }
        model.addAttribute(Constant.MESSAGE, "成功批阅试卷");
        return "back/index";
    }

}
