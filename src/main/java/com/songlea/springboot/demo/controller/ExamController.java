package com.songlea.springboot.demo.controller;

import com.songlea.springboot.demo.common.Constant;
import com.songlea.springboot.demo.common.UserRole;
import com.songlea.springboot.demo.pojo.Examroom;
import com.songlea.springboot.demo.pojo.Problem;
import com.songlea.springboot.demo.pojo.User;
import com.songlea.springboot.demo.service.IExamRoomService;
import com.songlea.springboot.demo.service.IPaperService;
import com.songlea.springboot.demo.service.ISolutionService;
import com.songlea.springboot.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description:
 * Created By xxm
 */
@Controller
public class ExamController {

    Logger logger = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    private IExamRoomService iExamRoomService;

    @Autowired
    private IPaperService iPaperService;

    @Autowired
    private ISolutionService iSolutionService;

    @Autowired
    private IUserService iUserService;

    /**
     * page sign in
     */
    @GetMapping("/index")
    public String index() {
        return "back/index";
    }

    /**
     * 前端: 选择考场,进入考场须知页面
     *
     * @param paperId
     * @return
     */
    @RequestMapping("/getpaper")
    public String checkIn(@RequestParam("paperId") Integer paperId,
                          @RequestParam("examroomId") Integer examroomId,
                          HttpSession session) {
        session.setAttribute(Constant.PAPERID, paperId);
        session.setAttribute(Constant.EXAMROOMID, examroomId);
        return "front/checkin";
    }

    /**
     * 前端: 根据试卷ID出题
     *
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/paper")
    public String doPaper(HttpSession session, Model model) {
        Integer paperId = (Integer) session.getAttribute(Constant.PAPERID);

        // 得到试卷题目
        List<Problem> problemsList = iPaperService.findPaperById(paperId);
        model.addAttribute(Constant.PROBLEMSLIST, problemsList);

        return "front/paper";
    }

    /**
     * 前端: 完成答题，提交答案
     *
     * @param allAnswers
     * @param session
     * @return
     */
    @GetMapping("/push")
    public String pushAnswer(@RequestParam("answer") List<String> allAnswers, HttpSession session, Model model) {
        User user = (User) session.getAttribute(UserRole.USER);
        Integer paperId = (Integer) session.getAttribute(Constant.PAPERID);
        StringBuilder examroomId = new StringBuilder();

        // 保存答卷
        boolean save = iSolutionService.saveSolutionRecord(user.getAccount(), paperId, allAnswers);

        if (save) {

            // 更新session中的user(exam_id)信息
            Integer newExamroomId = (Integer) session.getAttribute(Constant.EXAMROOMID);
            logger.info("newExamroomId: " + newExamroomId.toString()); // 4
            String oldExamroomId = user.getExamId();
            logger.info("oldExamroomId: " + oldExamroomId);
            if (StringUtils.isEmpty(oldExamroomId)) { // 首次答卷
                examroomId.append(newExamroomId);
                logger.info("examroomId: " + examroomId.toString());
            } else {
                examroomId.append(newExamroomId).append(",").append(oldExamroomId);
                logger.info("examroomId: " + examroomId.toString());
            }

            // 更新user(session和DB)
            boolean saveUser = iUserService.updateUserExamId(user, examroomId.toString());
            User newUser = iUserService.getUserByAccount(user.getAccount());
            session.setAttribute(UserRole.USER, newUser);

            if (saveUser) {
                // 主页信息
                List<Examroom> examrooms = iExamRoomService.findAll();
                model.addAttribute("examrooms", examrooms);
                return "front/examroom";
            }
        }
        model.addAttribute(Constant.ERRORMESSAGE, "试卷提交失败");
        return "error";
    }

    /**
     * 后台: 添加选择题
     *
     * @return
     */
    @GetMapping("/addchoice")
    public String addChoice() {
        return "back/addchoice";
    }

    /**
     * 后台: 添加简答题
     *
     * @return
     */
    @GetMapping("/addshortans")
    public String addShortAns() {
        return "back/addshortans";
    }

    /**
     * 后台: 查看所有考场信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/viewexamadmin")
    public String viewExamroom(Model model) {
        // 查阅考场所有信息
        List<Examroom> examroomList = iExamRoomService.findAll();
        model.addAttribute(Constant.EXAMROOMLIST, examroomList);
        return "back/examadmin";
    }

    /**
     * 后台:保存考场,随机生成试卷
     *
     * @param title
     * @param desction
     * @param model
     * @return
     */
    @RequestMapping("/saveexamroom")
    public String SaveExamroom(@RequestParam("title") String title,
                               @RequestParam("desction") String desction,
                               Model model) {
        // 随机生成试卷,三套
        String paperIdList = iPaperService.givePaper();

        // 保存考场 添加三套试卷id
        boolean save = iExamRoomService.saveExamRoom(title, desction, paperIdList);
        if (!save) {
            model.addAttribute(Constant.MESSAGE, "考场保存失败!");
            return "back/index";
        }
        model.addAttribute(Constant.MESSAGE, "考场保存成功!");
        // 保存考场信息
        return "back/index";
    }
}