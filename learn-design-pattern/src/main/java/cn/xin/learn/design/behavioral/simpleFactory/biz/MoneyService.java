package cn.xin.learn.design.behavioral.simpleFactory.biz;


import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 金钱服务-简单工厂模式
 * @date 2024年06月30日
 */
@Slf4j
public class MoneyService {
    /**
     * 充值
     */
    public void recharge() {
        log.info("充值");
    }

    /**
     * 提现
     */
    public void withdraw() {
        log.info("提现");
    }
}
