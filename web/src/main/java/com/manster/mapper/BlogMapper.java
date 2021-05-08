package com.manster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.pojo.Blog;

import com.manster.vo.BlogVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/4/22
 **/
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    //分页查询所有简单信息
    IPage<BlogVO> listBlog(Page<BlogVO> page);

    //分页查询搜索的blog,模糊查询 title 和 description
    IPage<BlogVO> listSearchBlog(Page<BlogVO> page, String query);

    //查询关于blog的一切
    BlogVO getBlogVO(Long id);

    //增加浏览量
    int addViews(Long id);

    //根据分类id查询blog
    IPage<BlogVO> listBlogByType(Page<BlogVO> page, Long id);

    //获取所有年份
    List<String> getGroupYears();

    //根据年份获得博客
    List<Blog> getBlogByYear(String year);

    //获取最新博客
    List<Blog> selectNewBlogs();

}
