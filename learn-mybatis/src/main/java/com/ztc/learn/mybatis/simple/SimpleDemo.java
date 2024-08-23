package com.ztc.learn.mybatis.simple;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年08月21日
 */
@Slf4j
public class SimpleDemo {
    public static void main(String[] args) {

        ClassLoader classLoader = SimpleDemo.class.getClassLoader();
        URL resource = classLoader.getResource("mybatis-config.xml");
        log.info("resource = {}", resource);

        String source = "mybatis-config.xml";

        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = sqlSessionFactory.openSession()){
            log.info("连接成功");
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> admin = mapper.queryUserByRole("1");
            log.info("admin = {}", admin);
        }
    }
}
