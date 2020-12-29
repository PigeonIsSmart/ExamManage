package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.dao.UserMapper;
import com.songlea.springboot.demo.pojo.Examroom;
import com.songlea.springboot.demo.pojo.Solution;
import com.songlea.springboot.demo.pojo.User;
import com.songlea.springboot.demo.service.IExamRoomService;
import com.songlea.springboot.demo.service.ISolutionService;
import com.songlea.springboot.demo.service.IUserService;
import com.songlea.springboot.demo.vo.ViewUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created By xxm
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ISolutionService iSolutionService;

    @Autowired
    private IExamRoomService iExamRoomService;

    @Override
    public boolean checkUser(String account, String passwd) {
        int i = userMapper.selectAccountAndPasswd(account, passwd);
        if (i == 0) {
            return false;
        }
        return true;
    }

    @Override
    public String getRole(String account) {
        return userMapper.selectRoleByAccount(account);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    @Override
    public boolean updateUserExamId(User newUser, String examroomId) {
        User user = new User();
        user.setId(newUser.getId());
        user.setAccount(newUser.getAccount());
        user.setPasswd(newUser.getPasswd());
        user.setUserRole(newUser.getUserRole());
        user.setExamId(examroomId);
        int resCount = userMapper.updateByPrimaryKey(user);
        return resCount > 0 ? true : false;
    }

    @Override
    public List<ViewUserVo> viewUserRecord(String account, String examId) {
        List<ViewUserVo> userRecords = new ArrayList<>();

        // 考场信息
        List<Examroom> userExamrooms = iExamRoomService.getUserAllExam(examId);
        // 考场信息判空
        if (userExamrooms == null) {
            return userRecords;
        }

        // 学生成绩
        List<Solution> records = iSolutionService.findRecords(account);
        for (int i = 0; i < userExamrooms.size(); i++) {
            // 组装考场信息
            ViewUserVo viewUserVo = new ViewUserVo();
            viewUserVo.setTitle(userExamrooms.get(i).getTitle());
            viewUserVo.setDesction(userExamrooms.get(i).getDesction());
            viewUserVo.setPaperId(userExamrooms.get(i).getPaperId());

            viewUserVo.setTotal(records.get(i).getTotal());

            userRecords.add(viewUserVo);
        }
        return userRecords;

    }
}
