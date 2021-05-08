package com.manster.service;

import com.manster.pojo.User;

/**
 * @Author manster
 * @Date 2021/4/22
 **/
public interface UserService {

    //验证登录信息
    User checkUser(String username, String password);

}
