package com.manster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.mapper.BlogMapper;
import com.manster.pojo.Blog;
import com.manster.service.BlogService;
import com.manster.util.MarkDownToHtmlUtils;
import com.manster.vo.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author manster
 * @Date 2021/5/1
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public IPage<BlogVO> listBlog(Page<BlogVO> page) {
        return blogMapper.listBlog(page);
    }

    @Override
    public IPage<BlogVO> listSearchBlog(Page<BlogVO> page, String query) {
        return blogMapper.listSearchBlog(page, query);
    }

    @Override
    public IPage<BlogVO> listBlogByType(Page<BlogVO> page, Long id) {
        return blogMapper.listBlogByType(page, id);
    }

    @Override
    public Integer countBlogByType(Long id) {
        return blogMapper.selectCount(new QueryWrapper<Blog>().eq("type_id", id));
    }

    @Override
    public List<Blog> listRecommendBlog() {
        return blogMapper.selectList(new QueryWrapper<Blog>().eq("published",1).eq("recommend",1));
    }

    @Override
    public Integer countBlog() {
        return blogMapper.selectCount(null);
    }

    @Override
    public Integer countSearchBlog(String query) {
        return blogMapper.selectCount(new QueryWrapper<Blog>().like("title", query).or().like("description", query));
    }

    @Transactional
    @Override
    public BlogVO getBlog(Long id) {
        //浏览数+1
        blogMapper.addViews(id);
        //查找
        BlogVO blogVO = blogMapper.getBlogVO(id);
        blogVO.setContent(MarkDownToHtmlUtils.markdownToHtmlExtensions(blogVO.getContent()));
        return blogVO;
    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogMapper.getGroupYears();
        Map<String, List<Blog>> map = new LinkedHashMap<>();
        for (String year : years) {
            map.put(year,blogMapper.getBlogByYear(year));
        }
        return map;
    }

    @Override
    public List<Blog> getNewBlogs() {
        return blogMapper.selectNewBlogs();
    }


}
