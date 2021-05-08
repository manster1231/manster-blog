package com.manster.vo;

import com.manster.pojo.Blog;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author manster
 * @Date 2021/5/1
 **/
@Data
public class TypeVO implements Serializable {

    private Long id;
    private String name;//分类名

    private List<Blog> blogs = new ArrayList<>();//该分类下所有的blog

    private static final long serialVersionUID = 1L;
}
