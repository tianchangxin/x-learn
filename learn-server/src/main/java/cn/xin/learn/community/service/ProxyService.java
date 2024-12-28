package cn.xin.learn.community.service;

import org.springframework.aop.framework.AopContext;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年09月02日
 */
public interface ProxyService<T> {
    @SuppressWarnings("unchecked")
    default T getProxy() {
        return (T) AopContext.currentProxy();
    }
}
