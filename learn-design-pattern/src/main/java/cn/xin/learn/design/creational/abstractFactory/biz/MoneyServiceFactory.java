package cn.xin.learn.design.creational.abstractFactory.biz;

import cn.xin.learn.design.creational.abstractFactory.core.AbstractFactory;
import cn.xin.learn.design.creational.abstractFactory.core.Service;

/**
 * @author tiancx
 * @description: 金钱服务-抽象工厂模式
 * @date 2024年07月18日
 */
public class MoneyServiceFactory implements AbstractFactory {
    @Override
    public Service getBean() {
        return new MoneyService();
    }
}
