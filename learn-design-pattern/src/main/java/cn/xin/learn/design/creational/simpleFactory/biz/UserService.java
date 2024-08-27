package cn.xin.learn.design.creational.simpleFactory.biz;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 用户服务-简单工厂模式
 * @date 2024年06月30日
 */
@Slf4j
public class UserService {
    /**
     * 添加用户
     */
    public void add() {
        log.info("添加用户");
    }

    /**
     * 删除用户
     */
    public void delete() {
        log.info("删除用户");
    }
}
