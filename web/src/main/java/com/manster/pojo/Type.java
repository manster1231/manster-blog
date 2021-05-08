package com.manster.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分类实体类
 * @Author manster
 * @Date 2021/4/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_type")
public class Type implements Serializable {

    @TableId(type= IdType.AUTO)
    private Long id;
    private String name;//分类名

    private static final long serialVersionUID = 1L;

}
