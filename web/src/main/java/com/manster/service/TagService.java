package com.manster.service;

import com.manster.vo.TagVO;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/5/1
 **/
public interface TagService {

    //列出所有标签及其所拥有的博客数
    List<TagVO> listTagVO();
}
