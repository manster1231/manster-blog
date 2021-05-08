package com.manster.service;

import com.manster.mapper.TagMapper;
import com.manster.vo.TagVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author manster
 * @Date 2021/5/1
 **/
@SpringBootTest
class TagServiceTest {

    @Autowired
    private TagMapper tagMapper;

    @Test
    public void listTagVO() {
        List<TagVO> tagVOS = tagMapper.listTagVO();
        for (TagVO tagVO : tagVOS) {
            System.out.println(tagVO);
        }
    }
}