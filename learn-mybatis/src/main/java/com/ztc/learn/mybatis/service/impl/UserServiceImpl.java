package com.ztc.learn.mybatis.service.impl;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.domain.User;
import com.ztc.learn.mybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jerry
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-08-20 10:51:07
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<User> getUserByRole(String role) {
        return userMapper.queryUserByRole(role);
    }
}




