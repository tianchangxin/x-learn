package cn.xin.learn.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xin
 * @description: 社区系统启动类
 * @date 2024年12月22日
 */
@SpringBootApplication
@Slf4j
//@EnableAspectJAutoProxy(exposeProxy = true)
public class CommunityServerApp {
    public static void main(String[] args) {
        log.info("开始启动");
        SpringApplication.run(CommunityServerApp.class, args);
        log.info("启动成功");
    }
}
