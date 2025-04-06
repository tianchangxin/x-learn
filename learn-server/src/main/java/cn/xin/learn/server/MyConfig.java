package cn.xin.learn.server;

import cn.xin.learn.server.web.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xin
 * @description: TODO
 * @date 2025年03月23日
 */
@Configuration
public class MyConfig {

    @Bean
    public User myUser() {
        return new User();
    }
}
