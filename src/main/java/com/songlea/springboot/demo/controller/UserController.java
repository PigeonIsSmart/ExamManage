package com.songlea.springboot.demo.controller;

import com.songlea.springboot.demo.common.Constant;
import com.songlea.springboot.demo.common.UserRole;
import com.songlea.springboot.demo.pojo.Examroom;
import com.songlea.springboot.demo.pojo.Solution;
import com.songlea.springboot.demo.pojo.User;
import com.songlea.springboot.demo.service.IExamRoomService;
import com.songlea.springboot.demo.service.IPaperService;
import com.songlea.springboot.demo.service.ISolutionService;
import com.songlea.springboot.demo.service.IUserService;
import com.songlea.springboot.demo.vo.ViewUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * Description: user controller
 * Created By xxm
 */
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IExamRoomService iExamRoomService;

    @Autowired
    private ISolutionService iSolutionService;

    /**
     * 用户登录
     *
     * @param account
     * @param passwd
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/login.do")
    public String login(@RequestParam("account") String account,
                        @RequestParam("passwd") String passwd,
                        HttpSession session,
                        Model model) {

        boolean checkUser = iUserService.checkUser(account, passwd);
        if (!checkUser) {
            return "front/signin";
        }

        User user = iUserService.getUserByAccount(account);
        session.setAttribute(UserRole.USER, user);
        // student
        if (Objects.equals(UserRole.STUDENT, user.getUserRole())) {
            List<Examroom> examrooms = iExamRoomService.findAll();
            model.addAttribute("examrooms", examrooms);
            return "front/examroom";
        }
        // teacher
        return "back/index";
    }

    /**
     * 查看用户信息
     *
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/viewuser")
    public String getUser(HttpSession session, Model model) {
        // user信息
        User user = (User) session.getAttribute(UserRole.USER);

        // 返回学生vo
        List<ViewUserVo> viewUserVos = iUserService.viewUserRecord(user.getAccount(), user.getExamId());

        model.addAttribute(Constant.USERLIST, viewUserVos);

        return "front/userpage";
    }

    /**
     * 用户退出
     *
     * @param session
     * @return
     */
    @GetMapping("/signout")
    public String logOut(HttpSession session) {
        session.removeAttribute(UserRole.USER);
        session.removeAttribute(Constant.PAPERID);
        return "front/signin";
    }
}
