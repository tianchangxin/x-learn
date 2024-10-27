package cn.xin.learn.design.structural.decorator.biz;

import cn.xin.learn.design.structural.decorator.core.Phone;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 装饰器模式-手机壳装饰
 * @date 2024年10月27日
 */
@Slf4j
public class ShellDecorator implements Phone {

    private final Phone decoratedPhone;

    public ShellDecorator(Phone decoratedPhone) {
        this.decoratedPhone = decoratedPhone;
    }
    /**
     * 原始功能
     */
    @Override
    public void show() {
        decoratedPhone.show();
        log.info("手机壳装饰");
    }
}
