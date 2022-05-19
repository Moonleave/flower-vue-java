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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserServiceImpl userService;


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
        //获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        //删除redis中的值
        redisCache.deleteObject("login:"+userid);
        return R.ok().code(200).message("注销成功");
    }

    @Override
    public R register(User user) {
        String registerUserName = user.getUserName();
        String registerPassword = user.getPassword();
        System.out.println("后端读取到你要注册的用户名是"+registerUserName+"   密码是"+registerPassword);
        User userJudge = userService.selectByUsername(registerUserName);
        System.out.println("userJudge=="+userJudge);
        if (userJudge!=null){
            return R.error().message("用户名已被注册").code(201);
        }
        else {
            //获取密码编码器
            //将用户的密码进行编码
            String password = passwordEncoder.encode(registerPassword);
            System.out.println("你输入的密码是:"+registerPassword);
            System.out.println("加密后的密码是:"+password);
            //将编码后的密码覆盖到用户信息中
            user.setPassword(password);
            //将用户信息持久化到数据库中
            userService.save(user);
            return R.ok().code(200).message("用户注册成功");
        }
    }
}
