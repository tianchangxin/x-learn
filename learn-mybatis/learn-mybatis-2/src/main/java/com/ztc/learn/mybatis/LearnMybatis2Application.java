package com.ztc.learn.mybatis;

import com.ztc.learn.mybatis.mapper.UserMapper;
import com.ztc.learn.mybatis.modle.vo.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class LearnMybatis2Application {

    public static void main(String[] args) {
        // SpringApplication.run(LearnMybatis2Application.class, args);

        // 步骤一:MyBatis初始化阶段
        String resource = "mybatis-config.xml";
        // 得到配置文件输入流
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 步骤二：数据读取
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<UserVo> userVos = mapper.queryUserByRole("2");
            for (UserVo userVo : userVos) {
                System.out.println("id："+userVo.getId()+"，username："+userVo.getUsername()+"，role："+userVo.getRole());
            }
        }


    }

}
