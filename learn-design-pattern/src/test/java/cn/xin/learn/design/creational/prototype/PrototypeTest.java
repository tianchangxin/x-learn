package cn.xin.learn.design.creational.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tiancx
 * @description: 原型模式测试
 * @date 2024年07月29日
 */
public class PrototypeTest {

    @Test
    public void testPrototype() throws CloneNotSupportedException {
        Notice notice = new Notice();
        User user = new User();
        user.setName("你");
        notice.setUser(user);
        notice.setTitle("开会");
        notice.setContent("请大家于明天下午2点到公司开会");
        Notice clone = notice.clone();
        User user1 = clone.getUser();
        user1.setName("我");
        System.out.println(notice);
        System.out.println(clone);
        Assertions.assertTrue(notice.getUser() != clone.getUser());
        Assertions.assertEquals(notice.getUser().getName(), "你");
        Assertions.assertEquals(clone.getUser().getName(), "我");
        Assertions.assertNotEquals(notice.getUser().getName(), clone.getUser().getName());
        Assertions.assertNotEquals(notice, clone);
        Assertions.assertEquals(notice.getTitle(), clone.getTitle());
        Assertions.assertEquals(notice.getContent(), clone.getContent());



    }
}
