package com.moon.flowerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author MoonLeaves
 * @create 2022-05-18 14:16
 * @describe:
 */
//@SpringBootApplication
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
public class FlowerApplicationContext {
    public static void main(String[]args){
        SpringApplication.run( FlowerApplicationContext.class,args);
    }
}
