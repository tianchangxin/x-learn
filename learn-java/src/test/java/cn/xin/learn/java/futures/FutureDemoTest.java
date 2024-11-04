package cn.xin.learn.java.futures;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年11月04日
 */
@Slf4j
public class FutureDemoTest {


    /**
     * 异步执行没有返回值的异步任务
     */
    @Test
    public void testRunAsync() throws Exception {
        //如果主线程不等的话，看不到异步线程的日志
        log.info("主线程开始");
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("runAsync");
        });
        log.info("主线程结束");
    }

    /**
     * 主线程等待异步线程执行完毕
     */
    @Test
    public void testRunAsyncMainSleep() throws Exception {
        log.info("主线程开始");
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("runAsync");
        });
        future.get();
        log.info("主线程结束");
    }
}
