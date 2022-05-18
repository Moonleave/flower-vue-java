package com.moon.userservice.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author MoonLeaves
 * @create 2022-05-12 9:21
 * @describe:
 */
@Service
public interface AuthService {

    /**
     * 根据用户名获取用户登录信息
     * @param username
     * @return
     */
    Map<String, Object> getUserInfo(String username);

}
