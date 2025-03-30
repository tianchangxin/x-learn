package cn.xin.learn.server.threads;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author xin
 * @description: 线程创建测试
 * @date 2025年02月20日
 */
@Slf4j
public class ThreadCreateTest {
    private static void threadSleep() {
        try {
            log.info("线程休眠2s");
            Thread.sleep(2000);
            log.info("线程休眠结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 继承Thread类
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            log.info("MyThread run");
            threadSleep();
        }

    }

    @Test
    public void testThreadCreate() throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
        log.info("结束");
    }

    /**
     * 实现callable接口
     */
    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("MyCallable run");
            threadSleep();
            return "MyCallable";
        }
    }

    @Test
    public void testCallable() throws Exception {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        futureTask.get();

        log.info("结束");
    }

    /**
     * futureTask
     */
    @Test
    public void testFutureTask() throws Exception {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 创建一系列 Callable
        Callable<Integer>[] tasks = new Callable[5];
        for (int i = 0; i < tasks.length; i++) {
            final int index = i;
            tasks[i] = () -> {
                TimeUnit.SECONDS.sleep(2);
                log.info("Task" + (index + 1) + " finished");
                return (index + 1) * 100;
            };
        }

        // 将 Callable 包装为 FutureTask，并提交到线程池
        FutureTask<Integer>[] futureTasks = new FutureTask[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            futureTasks[i] = new FutureTask<>(tasks[i]);
            executorService.submit(futureTasks[i]);
        }

        // 获取任务结果
        for (int i = 0; i < futureTasks.length; i++) {
            System.out.println("Result of task" + (i + 1) + ": " + futureTasks[i].get());
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
