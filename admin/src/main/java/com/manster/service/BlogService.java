package com.manster.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.pojo.Blog;
import com.manster.vo.BlogQuery;
import com.manster.vo.BlogVO;

/**
 * @Author manster
 * @Date 2021/4/25
 **/
public interface BlogService {

    //根据id查询一篇博客
    Blog getBlog(Long id);

    //查询所有blog
    IPage<BlogVO> listBlog(Page<BlogVO> page);

    //根据条件查询一组blog
    IPage<BlogVO> listBlogSearch(Page<BlogVO> page, BlogQuery blogQuery);

    //新增一篇博客
    int saveBlog(Blog blog);

    //修改Blog
    int updateBlog(Blog blog);

    //删除Blog
    int deleteBlog(Long id);

}
