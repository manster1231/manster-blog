package com.manster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manster.pojo.Type;
import com.manster.vo.TypeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author manster
 * @Date 2021/4/24
 **/
@Repository
public interface TypeMapper extends BaseMapper<Type> {

    //查询所有数量的type
    List<TypeVO> listTypeVO();

}
