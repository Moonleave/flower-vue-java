package com.moon.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MoonLeaves
 * @create 2022-05-11 17:51
 * @describe:
 */
@SpringBootApplication
public class UserApplicationContext {
    public static void main(String[]args){
        SpringApplication.run( UserApplicationContext.class,args);
    }
}
