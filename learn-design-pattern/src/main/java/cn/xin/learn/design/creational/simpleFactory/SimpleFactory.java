package cn.xin.learn.design.creational.simpleFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 简单工厂模式
 * @date 2024年06月30日
 */
@Slf4j
public class SimpleFactory {
    /**
     * 根据传入的类获取对应的实例
     * @param clazz 类
     * @return 实例
     * @param <T> 泛型
     */
    public static <T> T getBean(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.info("SimpleFactory getBean 实例化失败:{}",e.getMessage());
        }
        return null;
    }
}
