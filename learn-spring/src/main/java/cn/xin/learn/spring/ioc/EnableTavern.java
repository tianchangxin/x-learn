package cn.xin.learn.spring.ioc;

import cn.xin.learn.spring.ioc.config.BartenderConfiguration;
import cn.xin.learn.spring.ioc.entity.Boss;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author tiancx
 * @create 2023/11/1 0:20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Boss.class, BartenderConfiguration.class})
public @interface EnableTavern {
}
