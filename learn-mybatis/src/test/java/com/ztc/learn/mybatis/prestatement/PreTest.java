package com.ztc.learn.mybatis.prestatement;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年09月22日
 */
@Slf4j
public class PreTest {

    SqlSessionFactory sqlSessionFactory;

    @BeforeEach
    public void init() {
        String source = "mybatis-config.xml";
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 预处理测试
     */
    @Test
    public void testPreStatement() {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            log.info("✨连接成功");
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.queryUserPre(1);
            log.info("user = {}", user);
        }
    }

}
