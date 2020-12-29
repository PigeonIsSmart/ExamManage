package com.songlea.springboot.demo.service;

import com.songlea.springboot.demo.pojo.Examroom;

import java.util.List;

/**
 * Description:
 * Created By xxm
 */
public interface IExamRoomService {

    List<Examroom> findAll();

    List<Examroom> getUserAllExam(String examIds);

    boolean saveExamRoom(String title, String desction, String paperId);
}
