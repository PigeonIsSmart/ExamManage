package com.songlea.springboot.demo.dao;

import com.songlea.springboot.demo.pojo.Solution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SolutionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Solution record);

    int insertSelective(Solution record);

    Solution selectByPrimaryKey(Integer id);

    Solution selectByAccountAndPaperId(@Param("account") String account, @Param("paperId") Integer paperId);

    List<Solution> selectByAccount(String account);

    List<Solution> selectByStatus(String status);

    List<Solution> selectAll();

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKey(Solution record);

    int updateTotalAndStatusByAccount(Solution record);
}