package com.manster.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.pojo.Blog;
import com.manster.vo.BlogVO;

import java.util.List;
import java.util.Map;

/**
 * @Author manster
 * @Date 2021/5/1
 **/
public interface BlogService {

    //列出所有博客
    IPage<BlogVO> listBlog(Page<BlogVO> page);

    //根据简介或标题列出所有博客
    IPage<BlogVO> listSearchBlog(Page<BlogVO> page, String query);

    //根据分类id列出所有博客
    IPage<BlogVO> listBlogByType(Page<BlogVO> page, Long id);

    //根据分类id统计该分类下有多少blog
    Integer countBlogByType(Long id);

    //列出所有推荐博客
    List<Blog> listRecommendBlog();

    //统计博客总数
    Integer countBlog();

    //统计查询总数
    Integer countSearchBlog(String query);

    //根据blog的id查出博客详情
    BlogVO getBlog(Long id);

    //归档
    Map<String,List<Blog>> archiveBlog();

    //最新博客
    List<Blog> getNewBlogs();

}
