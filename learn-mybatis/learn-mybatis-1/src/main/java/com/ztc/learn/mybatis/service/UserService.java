package com.ztc.learn.mybatis.service;

import com.ztc.learn.mybatis.modle.vo.UserVo;

import java.util.List;

/**
* @author Jerry
* @description 针对表【user】的数据库操作Service
* @createDate 2024-08-20 10:51:07
*/

public interface UserService{

    List<UserVo> getUserByRole(String role);

}
