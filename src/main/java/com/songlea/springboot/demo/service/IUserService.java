package com.songlea.springboot.demo.service;

import com.songlea.springboot.demo.pojo.User;
import com.songlea.springboot.demo.vo.ViewUserVo;

import java.util.List;

/**
 * Description:
 * Created By xxm
 */
public interface IUserService {

    boolean checkUser(String account, String passwd);

    String getRole(String account);

    User getUserByAccount(String account);

    boolean updateUserExamId(User newUser, String examroomId);

    List<ViewUserVo> viewUserRecord(String account, String examId);
}
