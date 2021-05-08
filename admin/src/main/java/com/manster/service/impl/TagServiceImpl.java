package com.manster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.mapper.BlogAndTagsMapper;
import com.manster.mapper.TagMapper;
import com.manster.pojo.BlogAndTag;
import com.manster.pojo.Tag;
import com.manster.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/4/24
 **/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private BlogAndTagsMapper blogAndTagsMapper;

    @Transactional
    @Override
    public int saveTag(Tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagMapper.selectById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.selectOne(new QueryWrapper<Tag>().eq("name", name));
    }

    @Override
    public IPage<Tag> listTag(Page<Tag> page) {
        return tagMapper.selectPage(page, null);
    }

    @Override
    public List<Tag> listTag(){
        return tagMapper.selectList(null);
    }

    @Transactional
    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateById(tag);
    }

    @Transactional
    @Override
    public int deleteTag(Long id) {
        //删除标签时，将中间表关于该id的所有信息删除
        blogAndTagsMapper.delete(new QueryWrapper<BlogAndTag>().eq("tag_id",id));
        return tagMapper.deleteById(id);
    }
}
