package com.manster.controller;

import com.manster.pojo.Comment;
import com.manster.pojo.User;
import com.manster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author manster
 * @Date 2021/5/3
 **/
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${project.avatar}")
    private String avatar;
    @Value("${project.email}")
    private String email;
    @Value("${project.adminAvatar}")
    private String adminAvatar;

    /**
     * 得到列表
     * @param blogId 评论所属博客id
     * @param model 评论数据
     * @return 返回渲染fragment
     */
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment){
        if (email.equals(comment.getEmail())) {
            comment.setAdminComment(true);
            commentService.saveComment(comment, adminAvatar);
        } else {
            commentService.saveComment(comment, avatar);
        }
        return "redirect:/comments/" + comment.getBlogId();
    }

}
