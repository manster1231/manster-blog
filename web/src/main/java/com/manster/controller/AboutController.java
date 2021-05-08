package com.manster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author manster
 * @Date 2021/5/7
 **/
@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }

}
