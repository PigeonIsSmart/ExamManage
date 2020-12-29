package com.songlea.springboot.demo.dao;

import com.songlea.springboot.demo.pojo.Problem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);

    List<Problem> selectAll(String title);

    List<Problem> selectProblemListRandomlyByTitle(@Param("title") String title,@Param("limit") Integer limit);
}