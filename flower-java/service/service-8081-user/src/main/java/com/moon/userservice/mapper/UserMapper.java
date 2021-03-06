package com.moon.userservice.mapper;

import com.moon.userservice.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author MoonLeaves
 * @since 2022-05-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
