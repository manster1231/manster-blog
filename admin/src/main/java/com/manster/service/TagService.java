package com.manster.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.pojo.Tag;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/4/24
 **/
public interface TagService {

    /**
     * 保存一个标签
     * @param tag tag
     * @return 返回新增结果
     */
    int saveTag(Tag tag);

    /**
     * 获得一个标签
     * @param id tagId
     * @return 返回一个tag
     */
    Tag getTag(Long id);

    /**
     * 通过名字得到tag
     * @param name tagName
     * @return 返回一个tag
     */
    Tag getTagByName(String name);

    /**
     * 分页得到所有标签
     * @return 返回tag的分页集合
     */
    IPage<Tag> listTag(Page<Tag> page);

    /**
     * 得到所有标签
     * @return 返回tag的list集合
     */
    List<Tag> listTag();

    /**
     * 修改标签
     * @param tag 要修改的tag
     * @return 返回修改结果
     */
    int updateTag(Tag tag);

    /**
     * 删除标签
     * @param id tagId
     * @return 返回删除结果
     */
    int deleteTag(Long id);

}
