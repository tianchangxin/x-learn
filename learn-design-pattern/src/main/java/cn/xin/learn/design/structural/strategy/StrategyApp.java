package cn.xin.learn.design.structural.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tiancx
 * @description: 启动类
 * @date 2024年11月10日
 */
@SpringBootApplication
@Slf4j
public class StrategyApp {
    public static void main(String[] args) {
        log.info("StrategyApp start...");
        SpringApplication.run(StrategyApp.class, args);
        log.info("StrategyApp end...");
    }
}
