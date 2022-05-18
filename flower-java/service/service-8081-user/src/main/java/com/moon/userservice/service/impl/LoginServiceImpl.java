package com.moon.userservice.service.impl;

import com.moon.commonutils.R;
import com.moon.userservice.entity.User;
import com.moon.userservice.entity.overtity.LoginUser;
import com.moon.userservice.service.LoginService;
import com.moon.userservice.utils.JwtUtil;
import com.moon.userservice.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author MoonLeaves
 * @create 2022-05-10 14:08
 * @describe:
 */
@Service
public class LoginServiceImpl implements LoginService {


    /**
     * 登录功能流程介绍：
     * 我们主要是想用这个authenticationManager.authenticate()方法帮我们去验证是否通过了安全检查，
     * 这个方法需要一个参数，类型为UsernamePasswordAuthenticationToken，我们把我们需要验证的前端用户名和密码传入到他的属性中
     * 然后这个方法会返回一个Authentication的对象，这个对象封装了一个我们可以重写的对象，UserDetails的实现类，我们采用LoginUser接收。
     * 然后我们可以对这个对象进行验证，如果通过就用我我们这个对象中的id作为参数生成一个jwt的token,然后把这个token传入到redis的缓存中
     * @param user
     * @return
     */

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private RedisCache redisCache;


    @Override
    public R login(User user) {
        System.out.println("有人申请登录了，用户名是"+user.getUserName()+"    密码是"+user.getPassword());
        //AuthenticationManager authenticate进行用户认证,把用户名和密码封装成一个UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
//        然后去验证这个用户
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        //把完整的用户信息存入redis  userid作为key
        redisCache.setCacheObject("login:" + userid, loginUser);
        return R.ok().code(200).message("登陆成功").data("token",jwt);
    }

    @Override
    public R logout() {
        return null;
    }

    @Override
    public R register(User user) {
        return null;
    }
}
