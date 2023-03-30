package com.example.springboot_redis.component;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveListener_1 implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("我是监听者_1，我监听到的消息是 " + message.toString());
    }
}
