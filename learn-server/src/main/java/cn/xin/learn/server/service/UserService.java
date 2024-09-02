package cn.xin.learn.server.service;

import cn.xin.learn.server.annotations.CostTime;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年09月02日
 */
@Service
public class UserService implements ProxyService<UserService> {
    @CostTime
    public void getUser() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("get user");
        getProxy().getUserInfo();
    }

    @CostTime
    public void getUserInfo() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("get user info");
    }
}
