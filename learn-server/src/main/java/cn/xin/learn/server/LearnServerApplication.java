package cn.xin.learn.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author tiancx
 * @description: 启动类
 * @date 2024年07月07日
 */
@SpringBootApplication
@Slf4j
public class LearnServerApplication {
    public static void main(String[] args) {
        log.info("开始启动");
        SpringApplication.run(LearnServerApplication.class, args);
        log.info("启动成功");
    }

}
