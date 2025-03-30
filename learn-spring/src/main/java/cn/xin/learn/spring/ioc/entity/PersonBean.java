package cn.xin.learn.spring.ioc.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author xin
 * @description: spring ioc学习- 参考三分恶博主
 * @date 2025年03月15日
 */
@Slf4j
public class PersonBean implements InitializingBean, BeanFactoryAware, BeanNameAware, DisposableBean {
    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public PersonBean() {
        System.out.println("1.实例化Bean：我命由我不由天");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2.设置属性：我的名字叫" + name);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("3.调用BeanNameAware#setBeanName方法:我要给自己起个名字");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4.调用BeanFactoryAware#setBeanFactory方法：选好学校了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6.InitializingBean#afterPropertiesSet方法：入学登记");
    }

    public void init() {
        System.out.println("7.自定义init方法：努力上学ing");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9.DisposableBean#destroy方法：平淡的一生落幕了");
    }

    public void destroyMethod() {
        System.out.println("10.自定义destroy方法:睡了，别想叫醒我");
    }

    public void work() {
        System.out.println("Bean使用中：工作，只有对社会没有用的人才放假。。");
    }
}
