package cn.xin.learn.design.creational.singleton.core.ioc;

/**
 * @author tiancx
 * @description: Bean工厂
 * @date 2024年07月20日
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param beanName bean名称
     * @return bean 对象
     */
    Object getBean(String beanName) throws Exception;

    /**
     * 获取bean
     * @param requiredType bean类型
     * @return bean 对象
     * @param <T> bean类型
     * @throws Exception bean不存在时抛异常
     */
    <T> T getBean(Class<T> requiredType) throws Exception;

    /**
     * 是否包含bean
     * @param name bean名称
     * @return 是否包含
     */
    boolean containsBean(String name);


}
