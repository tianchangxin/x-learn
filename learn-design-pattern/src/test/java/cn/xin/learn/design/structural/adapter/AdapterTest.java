package cn.xin.learn.design.structural.adapter;

import org.junit.jupiter.api.Test;

/**
 * @author tiancx
 * @description: 适配器模式测试类
 * @date 2024年08月30日
 */
public class AdapterTest {

    @Test
    public void test() {
        Target<Adaptee> target = new Adapter();
        Adaptee adaptee = new Adaptee();
        target.target(adaptee);
    }
}
