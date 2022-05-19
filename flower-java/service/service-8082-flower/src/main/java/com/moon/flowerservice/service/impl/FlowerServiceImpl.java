package com.moon.flowerservice.service.impl;

import com.moon.flowerservice.entity.Flower;
import com.moon.flowerservice.mapper.FlowerMapper;
import com.moon.flowerservice.service.FlowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MoonLeaves
 * @since 2022-05-18
 */
@Service
public class FlowerServiceImpl extends ServiceImpl<FlowerMapper, Flower> implements FlowerService {

}
