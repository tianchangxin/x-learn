package cn.xin.learn.spring.ioc.conditions;

import cn.xin.learn.spring.ioc.config.BarConfiguration;
import cn.xin.learn.spring.ioc.config.BartenderConfiguration;
import cn.xin.learn.spring.ioc.config.TavernConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.stream.Stream;

/**
 * @author tiancx
 * @description: 条件装配测试
 * @date 2024年12月01日
 */
@SpringBootTest
@Slf4j
public class ConditionTest {
    @Resource
    private ApplicationContext applicationContext;

    @Test
    public void testProfile() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("city");
        context.register(BartenderConfiguration.class);
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(log::info);
    }

    @Test
    public void testConditional() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TavernConfiguration.class, BarConfiguration.class);
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(log::info);
    }
    
}
