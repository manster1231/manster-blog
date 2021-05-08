package com.manster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manster.pojo.Tag;
import com.manster.vo.TagVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/4/24
 **/
@Repository
public interface TagMapper extends BaseMapper<Tag> {

    //查询所有数量的type
    List<TagVO> listTagVO();

}
