package com.manster.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

/**
 * MD5加密
 * @Author manster
 * @Date 2021/4/24
 **/
public class MD5Utils {

    @Value("${project.salt}")
    private String salt;

    private static String thisSalt;

    @PostConstruct
    private void setThisSalt(){
        thisSalt = salt;
    }

    public static String digest(String str){
        return DigestUtils.md5DigestAsHex((str + thisSalt).getBytes(StandardCharsets.UTF_8));
    }

}
