package com.songlea.springboot.demo.service;

import com.songlea.springboot.demo.pojo.Problem;

import java.util.List;

/**
 * Description:
 * Created By xxm
 */
public interface IPaperService {

    List<Problem> findPaperById(Integer id);

    String givePaper();

}
