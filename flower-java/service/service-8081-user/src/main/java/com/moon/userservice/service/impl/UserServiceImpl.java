package com.moon.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moon.userservice.entity.User;
import com.moon.userservice.mapper.UserMapper;
import com.moon.userservice.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author MoonLeaves
 * @since 2022-05-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public User selectByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("user_name", username));
    }

}
