package cn.xin.learn.design.creational.singleton.core.ioc;

import lombok.Data;
import org.springframework.beans.PropertyValues;

/**
 * @author tiancx
 * @description: Bean定义
 * @date 2024年07月20日
 */
@Data
public class BeanDefinition {
    /**
     * bean class类
     */
    private Class<?> beanClass;

    /**
     * class 属性值
     */
    private PropertyValues propertyValues;

    /**
     * 通过反射 初始化方法名称
     */
    private String initMethodName;
}
