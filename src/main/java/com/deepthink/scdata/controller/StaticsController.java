package com.deepthink.scdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticsController {

    /**
     * 初始启动页
     * @return
     */
    @GetMapping("/")
    public String homePage(){
        return "index";
    }
}
