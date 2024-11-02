package com.ztc.learn.mybatis.mapper;

import com.ztc.learn.mybatis.modle.domain.User;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author Jerry
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2024-08-20 10:51:07
 * @Entity com.ztc.learn.mybatis.modle.domain.User
 */

@Mapper
public interface UserMapper {


    List<User> queryUserByRole(String role);

    List<User> queryUser(Integer id, String username, @Param("myEmail") String email);

    User queryUserById(Integer id);

    boolean updateUserNameById(@Param("id") Integer id, @Param("username") String username);

    /**
     * 测试预处理
     */
    User queryUserPre(@Param("id") Integer id);

    /**
     * 插入用户 - 测试使用
     */
    void insertUser(@Param("list") List<User> list);


    User queryUserByName(@Param("name") String name);
}




