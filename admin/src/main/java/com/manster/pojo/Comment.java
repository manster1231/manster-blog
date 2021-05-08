package com.manster.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 评论实体类
 * @Author manster
 * @Date 2021/4/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_comment")
public class Comment implements Serializable {

    @TableId(type= IdType.AUTO)
    private Long id;
    private String nickname;//昵称
    private String email;//邮箱
    private String content;//内容
    private String avatar;//头像
    private LocalDateTime createTime;//创建时间

    private Long blogId; //博客id
    private Long parentCommentId;  //父评论id
    private String parentNickname; //父昵称

    private boolean adminComment;//管理员评论

    private static final long serialVersionUID = 1L;
}
