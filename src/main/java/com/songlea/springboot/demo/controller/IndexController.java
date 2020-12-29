package com.songlea.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description: index
 * Created By xxm
 */
@Controller
public class IndexController {

    /**
     * page sign in
     */
    @GetMapping("/login")
    public String login() {
        return "front/signin";
    }


}
