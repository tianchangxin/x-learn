package cn.xin.learn.server.threads;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xin
 * @description: 可重入锁
 * @date 2025年02月22日
 */
@Slf4j
@Data
public class ReentrantLockDemo {
    private Integer count = 0;
    private ReentrantLock lock = new ReentrantLock(true);

    public void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }

    }

    /**
     * 测试
     */
    @Test
    public void testAdd() {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        for (int i = 0; i < 10000; i++) {
            new Thread(reentrantLockDemo::add).start();
        }
        threadSleep();
        System.out.println(reentrantLockDemo.getCount());
    }


    private static void threadSleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
