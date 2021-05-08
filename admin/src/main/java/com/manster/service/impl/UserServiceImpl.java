package com.manster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.manster.mapper.UserMapper;
import com.manster.pojo.User;
import com.manster.service.UserService;
import com.manster.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author manster
 * @Date 2021/4/22
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.selectOne(new QueryWrapper<User>()
                .eq("username",username)
                .eq("password",MD5Utils.digest(password)));
        return user;
    }
}
