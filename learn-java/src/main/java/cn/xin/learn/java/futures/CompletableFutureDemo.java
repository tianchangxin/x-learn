package cn.xin.learn.java.futures;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author tiancx
 * @description: CompletableFutureDemo
 * @date 2024年11月03日
 */
@Slf4j
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            queryUer();
        });
        Thread.sleep(Integer.MAX_VALUE);
    }


    public static void queryUer(){
        try {
            Thread.sleep(2000);
            log.info("query user");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
