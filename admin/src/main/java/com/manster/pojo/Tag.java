package com.manster.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 标签实体类
 * @Author manster
 * @Date 2021/4/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_tag")
public class Tag implements Serializable {

    @TableId(type= IdType.AUTO)
    private Long id;
    private String name;//标签名

    private static final long serialVersionUID = 1L;
}
