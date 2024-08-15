package cn.xin.learn.spring.ioc;

import cn.xin.learn.spring.ioc.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tiancx
 * @description:
 * @date 2024年08月12日
 */
public class AnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User bean = context.getBean(User.class);
        System.out.println(bean);
        context.close();
    }

}
