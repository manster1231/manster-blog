package com.manster.controller;

import com.manster.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author manster
 * @Date 2021/5/1
 **/
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;


    @GetMapping("/blog/{id}")
    public String blog(@PathVariable("id") Long id, Model model){
        model.addAttribute("blog", blogService.getBlog(id));
        return "blog";
    }

}
