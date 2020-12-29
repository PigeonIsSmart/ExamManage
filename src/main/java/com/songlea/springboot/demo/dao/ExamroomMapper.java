package com.songlea.springboot.demo.dao;

import com.songlea.springboot.demo.pojo.Examroom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamroomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Examroom record);

    int insertSelective(Examroom record);

    Examroom selectByPrimaryKey(Integer id);

    List<Examroom> selectAll();

    int updateByPrimaryKeySelective(Examroom record);

    int updateByPrimaryKey(Examroom record);
}