package cn.xin.learn.spring.ioc;

import cn.xin.learn.spring.ioc.entity.PersonBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tiancx
 * @description:
 * @date 2024年08月12日
 */
public class AnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PersonBean bean = context.getBean(PersonBean.class);
        System.out.println(bean);
        context.close();
    }

}
