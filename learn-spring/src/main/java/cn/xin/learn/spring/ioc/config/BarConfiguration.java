package cn.xin.learn.spring.ioc.config;

import cn.xin.learn.spring.ioc.conditons.ExistBossConditon;
import cn.xin.learn.spring.ioc.entity.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author tiancx
 * @create 2023/11/2 0:07
 */
@Configuration
public class BarConfiguration {
    @Conditional(ExistBossConditon.class)
    @Bean
    public Bar bbar() {
        return new Bar();
    }
}
