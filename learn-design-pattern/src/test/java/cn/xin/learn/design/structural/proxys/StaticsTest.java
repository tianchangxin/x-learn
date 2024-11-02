package cn.xin.learn.design.structural.proxys;

import cn.xin.learn.design.structural.proxys.biz.UserService;
import cn.xin.learn.design.structural.proxys.statics.UserServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author tiancx
 * @description: 代理模式-静态代理
 * @date 2024年11月02日
 */
@Slf4j
public class StaticsTest {
    @Test
    public void testStatics() {
        UserService userServiceProxy = new UserServiceProxy();
        String talk = userServiceProxy.talk();
        log.info("talk:{}", talk);
    }
}
