package com.example.springboot_redis.config;

import com.example.springboot_redis.component.ReceiveListener;
import com.example.springboot_redis.component.ReceiveListener_1;
import com.example.springboot_redis.component.ReceiveListener_object;
import com.example.springboot_redis.constant.ConstantEnum;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * 监听容器
 */
@Configuration
public class ReceiveListenerConfig extends CachingConfigurerSupport {

    /**
     * 消息监听容器
     *
     * @param factory
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory factory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        //订阅一个通道 该处的通道名是发布消息时的名称
        container.addMessageListener(catAdapter(), new PatternTopic(ConstantEnum.STR_TOPIC.getValue()));
        container.addMessageListener(catAdapter_1(), new PatternTopic(ConstantEnum.STR_TOPIC.getValue()));
        container.addMessageListener(catAdapter_obj(), new PatternTopic(ConstantEnum.STU_TOPIC.getValue()));
        return container;
    }

    /**
     * 消息监听适配器，绑定消息处理器
     *
     * @return
     */
    @Bean
    MessageListenerAdapter catAdapter(){
        return new MessageListenerAdapter(new ReceiveListener());
    }

    @Bean
    MessageListenerAdapter catAdapter_1(){
        return new MessageListenerAdapter(new ReceiveListener_1());
    }

    @Bean
    MessageListenerAdapter catAdapter_obj(){
        return new MessageListenerAdapter(new ReceiveListener_object());
    }
}
