package com.moon.userservice.controller;

import com.moon.commonutils.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MoonLeaves
 * @create 2022-05-11 19:07
 * @describe:
 */
@RestController
@CrossOrigin
@RequestMapping("/api/")
public class HelloController {
    @RequestMapping("/hello")
    public R hello(){
        return  R.ok().code(200).data("message","hello,word,i am nobody");
    }

    @PreAuthorize("hasAuthority('customer')")
    @RequestMapping("/helloCustomer")
    public R helloCustomer(){
        return  R.ok().code(200).data("message","hello,word,i am a Customer");
    }
    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping("/helloAdmin")
    public R helloAdmin(){
        return  R.ok().code(200).data("message","hello,word,i am an Admin");
    }
}
