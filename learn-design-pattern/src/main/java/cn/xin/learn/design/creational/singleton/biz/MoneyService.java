package cn.xin.learn.design.creational.singleton.biz;

import cn.xin.learn.design.creational.singleton.core.annotations.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 金钱服务-单例模式
 * @date 2024年07月20日
 */
@Component
@Slf4j
public class MoneyService {
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
