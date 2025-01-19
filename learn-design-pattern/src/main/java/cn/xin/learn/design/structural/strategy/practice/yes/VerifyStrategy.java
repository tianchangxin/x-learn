package cn.xin.learn.design.structural.strategy.practice.yes;

/**
 * @author tiancx
 * @description: 验证策略接口
 * @date 2024年11月16日
 */
public interface VerifyStrategy<T> {
    String verify(T param);
}
