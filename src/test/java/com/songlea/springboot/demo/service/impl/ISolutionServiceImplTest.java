package com.songlea.springboot.demo.service.impl;

import com.songlea.springboot.demo.service.ISolutionService;
import com.songlea.springboot.demo.vo.ViewPaperVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ISolutionServiceImplTest {

    @Autowired
    private ISolutionService iSolutionService;

    @Test
    public void viewStudentChoiceAns() {
        List<ViewPaperVo> viewPaperVos = iSolutionService.viewStudentChoiceAns("201512030230", 1);
        for (ViewPaperVo viewPaperVo : viewPaperVos) {
            System.out.println(viewPaperVo);
        }
    }

    @Test
    public void viewStudentShortAns() {
        List<ViewPaperVo> viewPaperVos = iSolutionService.viewStudentShortAns("201512030230", 1);
        for (ViewPaperVo viewPaperVo : viewPaperVos) {
            System.out.println(viewPaperVo);
        }
    }
}