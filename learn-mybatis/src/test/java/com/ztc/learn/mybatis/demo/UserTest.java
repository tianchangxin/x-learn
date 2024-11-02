package com.ztc.learn.mybatis.demo;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author tiancx
 * @description: 用户测试类
 * @date 2024年11月02日
 */
public class UserTest {

    @Test
    public void testUser(){
        String source = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // sqlSession
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = sqlSession.selectOne("com.ztc.learn.mybatis.mapper.UserMapper.queryUserByName", "花时");
//        System.out.println(user);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User queried = mapper.queryUserByName("花时");
        System.out.println(queried);
    }
}
