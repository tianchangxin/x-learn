package cn.xin.learn.design.structural.decorator;

import cn.xin.learn.design.structural.decorator.biz.MembraneDecorator;
import cn.xin.learn.design.structural.decorator.biz.MyPhone;
import cn.xin.learn.design.structural.decorator.biz.ShellDecorator;
import cn.xin.learn.design.structural.decorator.core.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author tiancx
 * @description: 装饰器模式-测试类
 * @date 2024年10月27日
 */
@Slf4j
public class DecoratorTest {
    @Test
    public void test() {
        // 创建一个具体的装饰者对象，并将其传递给构造函数
        Phone myPhone = new MyPhone();
        //装饰手机壳
        myPhone = new ShellDecorator(myPhone);
        //装饰钢化膜
        myPhone = new MembraneDecorator(myPhone);

        myPhone.show();
    }
}
