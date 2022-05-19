package com.moon.userservice.controller;

import com.moon.commonutils.R;
import com.moon.userservice.entity.User;
import com.moon.userservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MoonLeaves
 * @create 2022-05-11 17:55
 * @describe:
 */


//TODO URL http://localhost:8081/api/user/register  post
@RestController
@CrossOrigin
@RequestMapping("/api/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("user/login")
    public R login(@RequestBody User user) {
        //登录
        return loginService.login(user);
    }

    @RequestMapping("user/logout")
    public R logout() {
        return loginService.logout();
    }

    @PostMapping("user/register")
    public R register(@RequestBody User user) {
        return loginService.register(user);

    }

}
