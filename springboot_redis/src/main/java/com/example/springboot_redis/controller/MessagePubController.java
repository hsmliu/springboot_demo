package com.example.springboot_redis.controller;

import com.example.springboot_redis.constant.ConstantEnum;
import com.example.springboot_redis.dao.Student;
import com.example.springboot_redis.util.RedisUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessagePubController {
    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/pub")
    public void pubMessage(String message){
        redisUtil.messageSend(ConstantEnum.STR_TOPIC.getValue(), message);
    }

    @PostMapping("/publish")
    public void pubMessage(@RequestBody Student student){
        redisUtil.messageSend(ConstantEnum.STU_TOPIC.getValue(), student);
    }
}
