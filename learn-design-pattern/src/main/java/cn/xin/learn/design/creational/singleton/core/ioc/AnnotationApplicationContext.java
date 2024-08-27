package cn.xin.learn.design.creational.singleton.core.ioc;

import cn.xin.learn.design.creational.singleton.core.annotations.Component;


import java.util.Set;

/**
 * @author tiancx
 * @description: 应用上下文
 * @date 2024年07月20日
 */
public class AnnotationApplicationContext extends AbstractBeanFactory {
    /**
     * 扫描需要注册的bean
     */
    public AnnotationApplicationContext(Set<Class<?>> classes) throws InstantiationException, IllegalAccessException {
        for (Class<?> target : classes) {
            if (target.isAnnotationPresent(Component.class)) {
                BeanDefinition definition = new BeanDefinition();
                definition.setBeanClass(target);
                definition.setInitMethodName(target.getSimpleName());
                addSingleton(target.getName(), target.newInstance());
            }
        }
    }
}
