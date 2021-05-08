package com.manster.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 博客和标签关系存到数据库中使用的类
 * @Author manster
 * @Date 2021/4/22
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_blog_tags")
public class BlogAndTag implements Serializable {

    private Long id;

    private Long tagId;
    private Long blogId;

    private static final long serialVersionUID = 1L;
}
