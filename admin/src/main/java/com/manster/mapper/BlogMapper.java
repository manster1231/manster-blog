package com.manster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.pojo.Blog;
import com.manster.vo.BlogQuery;
import com.manster.vo.BlogVO;
import org.springframework.stereotype.Repository;

/**
 * @Author manster
 * @Date 2021/4/22
 **/
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    //分页查询所有
    IPage<BlogVO> listBlog(Page<BlogVO> page);

    //根据BlogVO进行条件查询
    IPage<BlogVO> listBlogSearch(Page<BlogVO> page, BlogQuery blogQuery);


}
