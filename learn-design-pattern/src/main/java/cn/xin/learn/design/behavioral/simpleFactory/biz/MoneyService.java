package cn.xin.learn.design.behavioral.simpleFactory.biz;

/**
 * @author tiancx
 * @description: 金钱服务-简单工厂模式
 * @date 2024年06月30日
 */
public class MoneyService {
    /**
     * 充值
     */
    public void recharge() {
        System.out.println("充值");
    }

    /**
     * 提现
     */
    public void withdraw() {
        System.out.println("提现");
    }
}
