package com.ztc.learn.mybatis.service.impl;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.domain.User;
import com.ztc.learn.mybatis.service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jerry
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-08-20 10:51:07
 */
@Service
@RequiredArgsConstructor

@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<User> getUserByRole(String role) {
        return userMapper.queryUserByRole(role);
    }


    /**
     * 插入模拟用户数据
     */
    @Override
    public void insertUser() {

        long start = System.currentTimeMillis();
        // 模拟插入数据  1000万条

        //开100个线程插入数据
        for(int j = 0; j < 100; j++){
            List<User> list = new CopyOnWriteArrayList<>();
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    User instance = User.getInstance();
                    list.add(instance);
                }
                userMapper.insertUser(list);
            }).start();
        }
        long end = System.currentTimeMillis();
        log.info("插入数据耗时：{}ms", end - start);
    }


}




