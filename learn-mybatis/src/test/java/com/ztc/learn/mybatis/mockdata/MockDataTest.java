package com.ztc.learn.mybatis.mockdata;

import com.ztc.learn.mybatis.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tiancx
 * @description: 模拟数据测试
 * @date 2024年10月12日
 */
@SpringBootTest
public class MockDataTest {
    @Resource
    private UserService userService;


    @Test
    public void insertUser(){
        userService.insertUser();
    }
}
