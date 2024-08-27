package com.ztc.learn.mybatis.service.impl;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.vo.UserVo;
import com.ztc.learn.mybatis.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jerry
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-08-20 10:51:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserVo> getUserByRole(String role) {
        return userMapper.queryUserByRole(role);
    }
}




