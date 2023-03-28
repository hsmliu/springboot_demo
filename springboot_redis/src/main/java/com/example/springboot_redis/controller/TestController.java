package com.example.springboot_redis.controller;

import com.example.springboot_redis.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class TestController {

    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/add")
    public String addKey(String key, String value){
        redisUtil.set(key, value);
        return "OK";
    }

    @GetMapping("/get")
    public Object getValue(String key){
        return redisUtil.get(key);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
