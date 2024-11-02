package cn.xin.learn.design.structural.proxys.statics;

import cn.xin.learn.design.structural.proxys.biz.UserService;
import cn.xin.learn.design.structural.proxys.biz.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 代理模式-静态代理
 * @date 2024年11月02日
 */
@Slf4j
public class UserServiceProxy implements UserService {
    private final UserService userService = new UserServiceImpl();
    @Override
    public String talk() {
        log.info("静态代理：你有什么要说的？");
        return userService.talk();
    }
}
