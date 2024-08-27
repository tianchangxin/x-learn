package cn.xin.learn.design.creational.abstractFactory.biz;


import cn.xin.learn.design.creational.abstractFactory.core.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 金钱服务-简单工厂模式
 * @date 2024年06月30日
 */
@Slf4j
public class MoneyService implements Service {
    /**
     * 充值
     */
    public void add() {
        log.info("充值");
    }

    /**
     * 提现
     */
    public void delete() {
        log.info("提现");
    }
}
