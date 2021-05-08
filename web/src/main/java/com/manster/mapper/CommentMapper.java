package com.manster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manster.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/5/3
 **/
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

}
