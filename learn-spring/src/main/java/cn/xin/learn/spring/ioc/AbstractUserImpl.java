package cn.xin.learn.spring.ioc;

import org.springframework.stereotype.Service;

/**
 * @author xin
 * @description: TODO
 * @date 2025年03月16日
 */
@Service
public class AbstractUserImpl extends AbstractUser {
    public AbstractUserImpl() {
        System.out.println("2.实例化Bean：我命由我不由天");
    }
}
