package com.manster.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manster.pojo.Type;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/4/24
 **/
public interface TypeService {

    /**
     * 保存一个分类
     * @param type
     * @return
     */
    int saveType(Type type);

    /**
     * 获得一个分类
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 通过名字得到type
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 分页得到所有分类
     * @return
     */
    IPage<Type> listType(Page<Type> page);

    /**
     * 获取所有的分类
     * @return
     */
    List<Type> listType();

    /**
     * 获取该分类下的所有blog
     * @return
     */
    List<Type> listBlogType();

    /**
     * 修改分类
     * @param type
     * @return
     */
    int updateType(Type type);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int deleteType(Long id);

}
