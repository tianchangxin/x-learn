package cn.xin.test;

import cn.xin.learn.design.behavioral.simpleFactory.SimpleFactory;
import cn.xin.learn.design.behavioral.simpleFactory.biz.MoneyService;
import cn.xin.learn.design.behavioral.simpleFactory.biz.UserService;
import org.junit.jupiter.api.Test;

/**
 * @author tiancx
 * @description: 简单工厂模式测试
 * @date 2024年06月30日
 */
public class TestSimpleFactory {
    @Test
    public void testSimpleFactory() {
        UserService userService = SimpleFactory.getBean(UserService.class);
        userService.add();
        userService.delete();
        MoneyService moneyService = SimpleFactory.getBean(MoneyService.class);
        moneyService.recharge();
        moneyService.withdraw();
    }
}
