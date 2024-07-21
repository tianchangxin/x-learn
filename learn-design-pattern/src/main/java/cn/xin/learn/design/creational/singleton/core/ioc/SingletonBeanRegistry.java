package cn.xin.learn.design.creational.singleton.core.ioc;

/**
 * @author tiancx
 * @description: 单例bean注册接口
 * @date 2024年07月20日
 */
public interface SingletonBeanRegistry {

        Object getSingleton(String beanName);

        void addSingleton(String beanName, Object singletonObject);
}
