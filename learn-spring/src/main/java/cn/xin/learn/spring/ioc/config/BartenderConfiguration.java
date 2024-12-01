package cn.xin.learn.spring.ioc.config;

import cn.xin.learn.spring.ioc.entity.Bartender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author tiancx
 * @create 2023/11/1 23:52
 */
@Configuration
@Profile("city")
public class BartenderConfiguration {

    @Bean
    public Bartender getBartender() {
        return new Bartender("调酒师-01");
    }

    @Bean
    public Bartender getBartender02() {
        return new Bartender("调酒师-02");
    }
}
