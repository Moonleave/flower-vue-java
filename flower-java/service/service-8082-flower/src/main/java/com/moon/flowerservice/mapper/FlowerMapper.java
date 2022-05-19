package com.moon.flowerservice.mapper;

import com.moon.flowerservice.entity.Flower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MoonLeaves
 * @since 2022-05-18
 */
@Mapper
public interface FlowerMapper extends BaseMapper<Flower> {

}
