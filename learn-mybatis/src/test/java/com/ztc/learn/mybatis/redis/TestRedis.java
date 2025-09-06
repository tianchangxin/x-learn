package com.ztc.learn.mybatis.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author xin
 * @description: TODO
 * @date 2025年08月05日
 */
@SpringBootTest
public class TestRedis {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedis() {
        stringRedisTemplate.opsForValue().set("k1", "testValue");
        String value = stringRedisTemplate.opsForValue().get("k1");
        System.out.println("Retrieved value from Redis: " + value);
    }
}
