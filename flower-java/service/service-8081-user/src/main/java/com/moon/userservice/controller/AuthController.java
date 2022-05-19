package com.moon.userservice.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.moon.commonutils.R;
import com.moon.userservice.entity.User;
import com.moon.userservice.mapper.UserMapper;
import com.moon.userservice.service.AuthService;
import com.moon.userservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("getUserInfo")
    public R getUserInfo(HttpServletRequest httpServletRequest) {
//        获取到头文件中的数据
        String token = httpServletRequest.getHeader("token");
        System.out.println("我后端获取到了token是" + token);

        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("我后端通过token获取到了你的用户名" + username);
        Map<String, Object> userInfo = authService.getUserInfo(username);

        return R.ok().message("你竟然得到了一个token").code(200).data("userInfo", userInfo);
    }


    //用户购买
    @GetMapping("PurchaseByUserNameAndCutMoney")
    public R PurchaseByUserNameAndCutMoney(String userName, Integer cutMoney) {
        if (cutMoney==null){
            System.out.println("用户名为空");
        }
        User user = userService.selectByUsername(userName);
        user.setUserMoney(user.getUserMoney()-cutMoney);
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("user_name",userName);
        userMapper.update(user,updateWrapper);
        //请求跨域？
//        response.setHeader("Access-Control-Allow-Origin", "*");
        return R.ok().code(200).message("购买成功");
    }
}
