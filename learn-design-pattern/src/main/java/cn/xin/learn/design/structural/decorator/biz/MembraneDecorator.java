package cn.xin.learn.design.structural.decorator.biz;

import cn.xin.learn.design.structural.decorator.core.Phone;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: MembraneDecorator
 * @date 2024年10月27日
 */
@Slf4j
public class MembraneDecorator implements Phone {

    private final Phone decoratedPhone;

    public MembraneDecorator(Phone decoratedPhone) {
        this.decoratedPhone = decoratedPhone;
    }

    @Override
    public void show() {
        decoratedPhone.show();
        log.info("贴膜装饰");
    }
}
