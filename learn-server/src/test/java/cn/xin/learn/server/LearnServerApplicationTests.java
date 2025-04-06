package cn.xin.learn.server;

import cn.xin.learn.server.service.TcxService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LearnServerApplicationTests {
    @Resource
    TcxService tcxService;

    @Test
    void contextLoads() {
        tcxService.show();
    }


}
