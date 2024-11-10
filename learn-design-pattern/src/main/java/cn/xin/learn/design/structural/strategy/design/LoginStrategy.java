package cn.xin.learn.design.structural.strategy.design;

/**
 * @author tiancx
 * @description: 登录策略
 * @date 2024年11月10日
 */
public interface LoginStrategy<T> {
    /**
     * 校验
     */
    boolean valid(T param);
}
