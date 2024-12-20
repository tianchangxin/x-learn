package cn.xin.learn.java.futures;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
/**
 * @author tiancx
 * @description: FutureDemoTest
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

    /**
     * 异步执行有返回值的异步任务
     */
    @Test
    public void testSupply() throws Exception {
        log.info("主线程开始");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("supplyAsync");
            return "hello future";
        });
        String result = future.get();
        log.info("result={}", result);
        log.info("主线程结束");
    }

    /**
     * thenApply
     */
    @Test
    public void testThenApply() throws Exception {
        log.info("主线程开始");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("supplyAsync");
            return "hello future";
        });
        CompletableFuture<String> thenApply = future.thenApply(result -> {
            log.info("thenApply result = {}", result);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return result + ", hello thenApply";
        });
        String result = future.get();
        log.info("result = {}", result);
        log.info("主线程结束");
    }

    /**
     * accept
     */
    @Test
    public void testAccept() throws Exception {
        log.info("主线程开始");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("supplyAsync");
            return "hello future";
        });
        CompletableFuture<Void> accept = future.thenAccept(result -> {
            log.info("thenAccept 上个future result = {}", result);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("thenAccept 结束了");
        });
        accept.get();
        log.info("主线程结束");

    }

    /**
     * thenCombine
     */
    @Test
    public void testThenCombine() throws Exception {
        log.info("主线程开始");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("supplyAsync future1");
            return " hello ";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("supplyAsync future2");
            return " future ";
        });
        CompletableFuture<String> thenCombine = future1.thenCombine(future2, new BiFunction<String, String, String>() {
            /**
             * Applies this function to the given arguments.
             *
             * @param s1  the first function argument
             * @param s2 the second function argument
             * @return the function result
             */
            @Override
            public String apply(String s1, String s2) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("thenCombine s1:{},s2:{}", s1 , s2);
                return s1 + s2;
            }
        });
        String res = thenCombine.get();
        log.info("res={}", res);
    }

    /**
     * thenCompose
     */
    @Test
    public void testThenCompose() throws Exception {
        log.info("主线程开始");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("supplyAsync future1");
            return " hello ";
        });

        CompletableFuture<String> thenCompose = future1.thenCompose(s -> {
            log.info("thenCompose s:{}", s);
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("thenCompose future2");
                return s + " future ";
            });
        });
        String res = thenCompose.get();
        log.info("res={}", res);

    }

}
