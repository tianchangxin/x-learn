package cn.xin.learn.design.structural.proxys.statics.impl;

import cn.xin.learn.design.structural.proxys.statics.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 用户服务实现类
 * @date 2024年11月02日
 */
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public String talk() {
        return "我就说一句话：我就是这么牛";
    }
}
