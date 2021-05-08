package com.manster.service;

import com.manster.pojo.Comment;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/5/3
 **/
public interface CommentService {

    //获取博客评论列表
    List<Comment> listCommentByBlogId(Long blogId);

    //保存一条评论
    int saveComment(Comment comment, String avatar);

}
