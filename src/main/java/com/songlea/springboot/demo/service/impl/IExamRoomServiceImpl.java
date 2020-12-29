package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.dao.ExamroomMapper;
import com.songlea.springboot.demo.pojo.Examroom;
import com.songlea.springboot.demo.service.IExamRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:
 * Created By xxm
 */
@Service
public class IExamRoomServiceImpl implements IExamRoomService {

    @Autowired
    private ExamroomMapper examroomMapper;

    /**
     * 这里虽然是全查，但是返回唯一的paperId，代表一套试卷.
     *
     * @return
     */
    @Override
    public List<Examroom> findAll() {
        List<Examroom> examrooms = examroomMapper.selectAll();

        // 三套试题随便选一套，作为答卷
        Random random = new Random();
        int paperIdIndex = random.nextInt(3);
        for (Examroom examroom : examrooms) {
            String[] paperIdList = examroom.getPaperId().split(",");
            examroom.setPaperId(paperIdList[paperIdIndex]);
        }
        return examrooms;
    }

    @Override
    public List<Examroom> getUserAllExam(String examIds) {
        if (StringUtils.isEmpty(examIds))
            return null;

        List<Examroom> allExamrooms = new ArrayList<>();

        String[] examrooms = examIds.split(",");
        for (String examroom : examrooms) {
            if (StringUtils.isEmpty(examroom)) return null;
            allExamrooms.add(examroomMapper.selectByPrimaryKey(Integer.parseInt(examroom)));
        }

        return allExamrooms;
    }

    @Override
    public boolean saveExamRoom(String title, String desction, String paperId) {
        Examroom examroom = new Examroom();
        examroom.setPaperId(paperId);
        examroom.setTitle(title);
        examroom.setDesction(desction);
        int resCount = examroomMapper.insert(examroom);
        return resCount > 0 ? true : false;
    }
}
