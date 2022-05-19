package com.moon.userservice.service.impl;

import com.moon.commonutils.R;
import com.moon.userservice.entity.User;
import com.moon.userservice.service.AuthService;
import com.moon.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MoonLeaves
 * @create 2022-05-12 9:22
 * @describe:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserServiceImpl userService;


    /**
     * 根据用户名获取用户登录信息
     * @param username
     * @return
     */
    @Override
    public Map<String, Object> getUserInfo(String username) {
        Map<String, Object> result = new HashMap<>();
        System.out.println("准备查询用户信息");
        User user = userService.selectByUsername(username);
        System.out.println("查询结果"+user);
        if (user==null){
//            抛出异常
            System.out.println("没有查到信息");
        }
        //根据用户id获取操作权限值
        result.put("userName",user.getUserName());
        result.put("phoneNumber",user.getPhonenumber());
        result.put("userMoney",user.getUserMoney());
        return result;
    }

}
