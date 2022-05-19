package com.moon.flowerservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author MoonLeaves
 * @create 2022-05-18 14:17
 * @describe:
 */
@Configuration
@MapperScan("com.moon.mapper")
public class FlowerConfig {
}
