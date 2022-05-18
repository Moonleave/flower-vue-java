package com.moon.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moon.userservice.entity.User;
import com.moon.userservice.entity.overtity.LoginUser;
import com.moon.userservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author MoonLeaves
 * @create 2022-05-08 19:28
 * @describe:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        User user = userMapper.selectOne(wrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或密码错误");
        }    // 根据用户查询权限信息 添加到LoginUser中

        System.out.println("用户[" + user.getId() + "]准备获取权限");
//        menuMapper.selectPermsByUserId(user.getId());
//        测试写法
//        List<String> permissionKeyList=new ArrayList<>(Arrays.asList("test","admin"));
//        List<String> permissionKeyList =  menuMapper.selectPermsByUserId(user.getId());
        //封装成UserDetails对象返回
        //TODO 进行用户权限注入，这里是写死的customer
        List<String> permissionKeyList = new ArrayList<>(Arrays.asList("customer"));
        System.out.println("第一个权限是:[" + permissionKeyList.get(0)+"]");
        return new LoginUser(user,permissionKeyList);
    }
}
