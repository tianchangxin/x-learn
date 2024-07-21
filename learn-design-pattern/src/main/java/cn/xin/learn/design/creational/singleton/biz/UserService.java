package cn.xin.learn.design.creational.singleton.biz;

import cn.xin.learn.design.creational.singleton.core.annotations.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 用户服务-单例模式
 * @date 2024年07月20日
 */
@Component
@Slf4j
public class UserService {
    /**
     * 注册
     */
    public void add() {
        log.info("注册");
    }

    /**
     * 删除
     */
    public void delete() {
        log.info("删除");
    }
}
