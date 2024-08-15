package cn.xin.learn.spring.ioc;

import cn.xin.learn.spring.ioc.entity.User;
import org.springframework.context.annotation.Bean;

/**
 * @author tiancx
 * @description: 配置
 * @date 2024年08月12日
 */
public class Config {
    @Bean
    public User getUser() {
        return new User("tiancx", 18);
    }
}
