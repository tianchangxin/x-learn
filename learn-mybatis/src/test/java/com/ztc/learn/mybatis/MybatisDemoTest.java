package com.ztc.learn.mybatis;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.domain.User;
import com.ztc.learn.mybatis.simple.SimpleDemo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @author tiancx
 * @description: mybatis demo test
 * @date 2024年08月21日
 */
@Slf4j
public class MybatisDemoTest {
    @Test
    public void test() {
        System.out.println("MybatisDemoTest.test");
    }

    @Test
    public void testConfig() {
        ClassLoader classLoader = MybatisDemoTest.class.getClassLoader();
        URL resource = classLoader.getResource("mybatis-config.xml");
        System.out.println("resource = " + resource);
    }

    @Test
    public void testSimpleDemo() {
        String source = "mybatis-config.xml";

        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = sqlSessionFactory.openSession()){
            log.info("✨连接成功");
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> jerry = mapper.queryUser(1, "Jerry", "123");
            log.info("admin = {}", jerry);
        };
    }


    @Test
    public void testSession() {
        String source = "mybatis-config.xml";
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = sqlSessionFactory.openSession()){

            log.info("✨连接成功");
            //设置查询参数
            User user = new User();
            user.setId(1);
            user.setUsername("Jerry");
            String statement = "com.ztc.learn.mybatis.mapper.UserMapper.queryUser";
            List<Object> list = session.selectList(statement, user);
            log.info("list = {}", list);

            log.info("连接成功");
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> admin = mapper.queryUserByRole("1");
            log.info("admin = {}", admin);
        };
    }
}
