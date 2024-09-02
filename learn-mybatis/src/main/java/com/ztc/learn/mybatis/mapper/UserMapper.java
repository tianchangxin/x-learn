package com.ztc.learn.mybatis.mapper;

import com.ztc.learn.mybatis.modle.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jerry
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2024-08-20 10:51:07
 * @Entity com.ztc.learn.mybatis.modle.domain.User
 */

@Mapper
public interface UserMapper {

    public List<User> queryUserByRole(String role);

}




