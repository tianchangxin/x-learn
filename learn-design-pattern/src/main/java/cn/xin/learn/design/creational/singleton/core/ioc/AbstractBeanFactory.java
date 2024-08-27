package cn.xin.learn.design.creational.singleton.core.ioc;


/**
 * @author tiancx
 * @description: Bean工厂
 * @date 2024年07月20日
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws Exception {
        return getSingleton(beanName);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws Exception {
        Object bean = getBean(requiredType.getName());
        return (T) bean;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

}
