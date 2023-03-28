package com.example.springboot_redis;

import com.example.springboot_redis.util.RedisUtil;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    void contextLoads() {
    }


    @Test
    public void testRedis() {
        // 添加
        redisTemplate.opsForValue().set("name","沉默王二");
        // 查询
        System.out.println(redisTemplate.opsForValue().get("name"));
        // 删除
        redisTemplate.delete("name");

        // 更新
        redisTemplate.opsForValue().set("name","沉默王二的狗腿子");
        // 查询
        System.out.println(redisTemplate.opsForValue().get("name"));

        // 添加
        stringRedisTemplate.opsForValue().set("name","沉默王二");
        // 查询
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
        // 删除
        stringRedisTemplate.delete("name");
        // 更新
        stringRedisTemplate.opsForValue().set("name","沉默王二的狗腿子");
        // 查询
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

    @Test
    public void addKey(){
        redisUtil.set("test", "哈哈哈");
        System.out.println(redisUtil.get("test"));
    }

    @Test
    public void addMultiData() {
        // 批量添加 pattern查询用
        for (int i = 0; i < 10000; i++) {
            String key = "phone" + i;
            String key1 = "mail" + i;
            redisUtil.set(key, i);
            redisUtil.set(key1, i);
        }
    }

    @Test
    public void queryData(){
        String pattern = "key_1*";
        Set<String> scan = redisUtil.scanKey(pattern);
        System.out.println(scan);
    }
}
