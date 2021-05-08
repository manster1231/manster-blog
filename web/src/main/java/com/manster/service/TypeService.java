package com.manster.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.pojo.Type;
import com.manster.vo.BlogVO;
import com.manster.vo.TypeVO;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/4/24
 **/
public interface TypeService {

    //列出所有分类及其所拥有的博客数
    List<TypeVO> listTypeVO();

}
