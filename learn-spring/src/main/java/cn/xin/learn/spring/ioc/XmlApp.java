package cn.xin.learn.spring.ioc;

import cn.xin.learn.spring.ioc.entity.PersonBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * @author xin
 * @description: xml配置
 * @date 2025年03月15日
 */
public class XmlApp {
    public static void main(String[] args) {
        // 1. 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        // 2. 获取bean对象
        PersonBean personBean = context.getBean("personBean", PersonBean.class);
        // 3. 调用方法
        personBean.work();
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 4. 关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}
