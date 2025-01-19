package cn.xin.learn.design.structural.strategy.practice.yes;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tiancx
 * @description: 策略工厂
 * @date 2024年11月16日
 */
@Component
@SuppressWarnings("unchecked")
public class StrategyFactory {
    @Resource
    private ApplicationContext applicationContext;

    /***
     * 获取策略
     * @param type 类型
     * @return 策略
     */
    public <T> VerifyStrategy<T> getStrategy(String type) {
        return applicationContext.getBean(type + "Strategy", VerifyStrategy.class);
    }
}
