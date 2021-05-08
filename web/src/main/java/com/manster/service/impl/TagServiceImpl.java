package com.manster.service.impl;

import com.manster.mapper.TagMapper;
import com.manster.service.TagService;
import com.manster.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/5/1
 **/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagVO> listTagVO() {
        return tagMapper.listTagVO();
    }
}
