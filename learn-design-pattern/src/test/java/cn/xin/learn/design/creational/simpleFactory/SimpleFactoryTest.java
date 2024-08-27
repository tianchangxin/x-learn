package cn.xin.learn.design.creational.simpleFactory;

import cn.xin.learn.design.creational.simpleFactory.biz.MoneyService;
import cn.xin.learn.design.creational.simpleFactory.biz.UserService;
import org.junit.jupiter.api.Test;


class SimpleFactoryTest {
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