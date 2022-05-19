package com.moon.flowerservice.controller;


import com.moon.commonutils.R;
import com.moon.flowerservice.entity.Flower;
import com.moon.flowerservice.service.impl.FlowerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MoonLeaves
 * @since 2022-05-18
 */
@RestController
@RequestMapping("/api/flower")
@CrossOrigin
public class FlowerController {

    @Autowired
    FlowerServiceImpl flowerService=new FlowerServiceImpl();
    @GetMapping("hello")
    public R sayFlower(){
        return R.ok().data("hello,flower","hello");

    }

    @GetMapping("getAllFlowerInfo")
    public R getAllFlowerInfo(){
        List<Flower> flowerList = flowerService.list(null);
        return R.ok().code(200).data("flowerList",flowerList);
    }
}

