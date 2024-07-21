package cn.xin.learn.design.creational.singleton.core.ioc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tiancx
 * @description: 单例bean注册
 * @date 2024年07月20日
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
