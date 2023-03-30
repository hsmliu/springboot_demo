package com.example.springboot_redis.component;

import com.example.springboot_redis.dao.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class ReceiveListener_object implements MessageListener {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("我是监听者，我监听到的消息是 " + message.toString());
        try {
            // 反序列化收到的消息
            Student student = objectMapper.readValue(message.getBody(), Student.class);
            System.out.println("学生名称：" + student.getName());
            System.out.println("学生年龄：" + student.getAge());
            System.out.println("学生性别：" + student.getGender());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
