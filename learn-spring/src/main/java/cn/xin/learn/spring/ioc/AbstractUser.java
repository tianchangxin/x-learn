package cn.xin.learn.spring.ioc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xin
 * @description: TODO
 * @date 2025年03月16日
 */
@AllArgsConstructor
@Data
@Component
public abstract class AbstractUser {
    private String id;
    private String name;

    AbstractUser() {
        System.out.println("1.实例化Bean：我命由我不由天");
    }
}

