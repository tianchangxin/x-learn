package com.ztc.learn.mybatis.cache;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author tiancx
 * @description: mybatis缓存测试
 * @date 2024年09月16日
 * <p>
 * 参考文档：https://tech.meituan.com/2018/01/19/mybatis-cache.html
 */
@Slf4j
public class MybatisCacheTest {

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
     * 测试一级缓存-同一个sqlSession
     */
    @Test
    public void testFirstLevelCache() {
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            log.info("✨连接成功");
            UserMapper mapper = session.getMapper(UserMapper.class);

            List<User> jerry1 = mapper.queryUser(1, "Jerry", "123");
            log.info("jerry1 = {},hashCode:{}", jerry1,jerry1.hashCode());
            List<User> jerry2 = mapper.queryUser(1, "Jerry", "123");
            log.info("jerry2 = {},hashCode:{}", jerry2,jerry2.hashCode());
            Assertions.assertArrayEquals(jerry1.toArray(), jerry2.toArray());

            UserMapper mapper1 = session.getMapper(UserMapper.class);
            List<User> jerry3 = mapper1.queryUser(1, "Jerry", "123");
            log.info("jerry3 = {},hashCode:{}", jerry3,jerry3.hashCode());
            Assertions.assertArrayEquals(jerry1.toArray(), jerry3.toArray());
        };
    }

    /**
     * 测试一级缓存-同一个sqlSession，有修改操作
     */
    @Test
    public void testFirstLevelCache2() {
        try(SqlSession session = sqlSessionFactory.openSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user1 = mapper.queryUserById(1);
            Assertions.assertEquals("admin", user1.getUsername());

            mapper.updateUserNameById(1, "admin-修改版");
            User user2 = mapper.queryUserById(1);
            Assertions.assertEquals("admin-修改版", user2.getUsername());

            //一级缓存中，已经被修改了
            User user3 = mapper.queryUserById(1);
            Assertions.assertEquals("admin-修改版", user3.getUsername());

            //修改回去，方便后续测试

            mapper.updateUserNameById(1, "admin");

        }
    }


    /**
     * 测试一级缓存-不同sqlSession
     */
    @Test
    public void testFirstLevelCache3() {
        List<User> jerry1;
        List<User> jerry2;
        SqlSession session1 = sqlSessionFactory.openSession();
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        jerry1 = mapper1.queryUser(1, "Jerry", "123");

        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        jerry2 = mapper2.queryUser(1, "Jerry", "123");
        //一级缓存中，不同的sqlSession，所以两个对象不相等
        Assertions.assertNotEquals(jerry1.toArray(), jerry2.toArray());
        session1.close();
        session2.close();
    }

    /**
     * 测试一级缓存-不同sqlSession，有修改操作
     */
    @Test
    public void testFirstLevelCache4() {


        SqlSession session1 = sqlSessionFactory.openSession();
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(1);

        Assertions.assertEquals("admin", user1.getUsername());

        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        mapper2.updateUserNameById(1, "admin-修改版");


        User user3 = mapper2.queryUserById(1);

        Assertions.assertEquals("admin-修改版", user3.getUsername());

        //SqlSession2的缓存已经被修改了，【但是SqlSession1的缓存还是没有被修改，读到了脏数据】
        User user2 = mapper1.queryUserById(1);
        Assertions.assertEquals("admin", user2.getUsername());

        mapper2.updateUserNameById(1, "admin");
        session1.close();
        session2.close();
    }
}
