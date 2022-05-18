package com.moon.userservice.controller;

import com.moon.commonutils.R;
import com.moon.userservice.entity.User;
import com.moon.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author MoonLeaves
 * @create 2022-05-11 21:28
 * @describe:
 */
//http://localhost:8081/api/user/auth/getUserInfo
//前端要用的根据token获取用户信息
@CrossOrigin
@RestController
@RequestMapping("/api/user/auth/")
public class AuthController {

    @Autowired
    private AuthService authService;


    @GetMapping("getUserInfo")
    public R getUserInfo(HttpServletRequest httpServletRequest) {
//        获取到头文件中的数据
        String token = httpServletRequest.getHeader("token");
        System.out.println("我后端获取到了token是"+token);

        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("我后端通过token获取到了你的用户名"+username);
        Map<String, Object> userInfo = authService.getUserInfo(username);

        return R.ok().message("你竟然得到了一个token").code(200).data("userInfo",userInfo);
    }
}
