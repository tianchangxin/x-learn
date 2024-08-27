package cn.xin.learn.design.creational.builder;

import cn.xin.learn.design.creational.builder.biz.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author tiancx
 * @description: 建造者模式测试类
 * @date 2024年07月18日
 */
public class BuilderTest {
    @Test
    public void testBuilder() {
        User user = User.builder().name("不愁钱").age(18).build();
        Assertions.assertEquals("不愁钱", user.getName());
        Assertions.assertEquals(18, user.getAge());
    }
}
