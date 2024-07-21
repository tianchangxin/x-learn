package cn.xin.learn.design.creational.singleton;

import cn.hutool.core.lang.ClassScanner;
import cn.xin.learn.design.creational.singleton.biz.UserService;
import cn.xin.learn.design.creational.singleton.core.DoubleCheckSingleton;
import cn.xin.learn.design.creational.singleton.core.EagerSingleton;
import cn.xin.learn.design.creational.singleton.core.LazySingleton;
import cn.xin.learn.design.creational.singleton.core.ThreadSafeLazySingleton;
import cn.xin.learn.design.creational.singleton.core.ioc.AnnotationApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {
    @Test
    void getInstance() {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                LazySingleton lazySingleton1 = LazySingleton.getInstance();
                LazySingleton lazySingleton2 = LazySingleton.getInstance();
                assertEquals(lazySingleton1, lazySingleton2);
            }).start();
        }
    }

    @Test
    void getThreadSafeLazyInstance() throws InterruptedException {
        final int threadCount = 100000; // 减少线程数量以减轻资源负担
        CountDownLatch latch = new CountDownLatch(threadCount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            CountDownLatch finalLatch = latch;
            new Thread(() -> {
                ThreadSafeLazySingleton instance1 = ThreadSafeLazySingleton.getInstance();
                ThreadSafeLazySingleton instance2 = ThreadSafeLazySingleton.getInstance();
                assertEquals(instance1, instance2);
                finalLatch.countDown(); // 通知CountDownLatch一个线程已经完成
            }).start();
        }
        latch.await(); // 等待所有线程完成
        long end = System.currentTimeMillis();
        System.out.println("ThreadSafeLazySingleton: " + (end - start) + "ms");

        // 重置CountDownLatch并测试第二个单例
        latch = new CountDownLatch(threadCount);
        start = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            CountDownLatch finalLatch1 = latch;
            new Thread(() -> {
                DoubleCheckSingleton instance1 = DoubleCheckSingleton.getInstance();
                DoubleCheckSingleton instance2 = DoubleCheckSingleton.getInstance();
                assertEquals(instance1, instance2);
                finalLatch1.countDown();
            }).start();
        }
        latch.await();
        end = System.currentTimeMillis();
        System.out.println("DoubleCheckLockingSingleton: " + (end - start) + "ms");
    }

    @Test
    void testEagerSingleton() {
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
                EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
                assertEquals(eagerSingleton1, eagerSingleton2);
            }).start();
        }
    }

    @Test
    void testIoc() throws Exception {
        //找包下的类
        String packageName = "cn.xin.learn.design.creational.singleton";
        AnnotationApplicationContext context = new AnnotationApplicationContext(ClassScanner.scanPackage(packageName));
        Object bean = context.getBean(UserService.class.getName());
        Assertions.assertEquals(UserService.class, bean.getClass());
        UserService service = context.getBean(UserService.class);
        Assertions.assertEquals(service, bean);
    }
}