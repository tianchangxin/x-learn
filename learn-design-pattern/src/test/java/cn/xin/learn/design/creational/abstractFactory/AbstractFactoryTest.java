package cn.xin.learn.design.creational.abstractFactory;

import cn.xin.learn.design.creational.abstractFactory.biz.MoneyServiceFactory;
import cn.xin.learn.design.creational.abstractFactory.biz.UserServiceFactory;
import cn.xin.learn.design.creational.abstractFactory.core.AbstractFactory;
import cn.xin.learn.design.creational.abstractFactory.core.Service;
import org.junit.jupiter.api.Test;

/**
 * @author tiancx
 * @description: 抽象工厂模式测试类
 * @date 2024年07月18日
 */
public class AbstractFactoryTest {

    @Test
    public void testAbstractFactory() {
        // 通过抽象工厂获取用户服务
        AbstractFactory abstractFactory = new UserServiceFactory();
        Service service = abstractFactory.getBean();
        service.add();
        service.delete();
        // 通过抽象工厂获取金钱服务
        abstractFactory = new MoneyServiceFactory();
        service = abstractFactory.getBean();
        service.add();
        service.delete();
    }
}
