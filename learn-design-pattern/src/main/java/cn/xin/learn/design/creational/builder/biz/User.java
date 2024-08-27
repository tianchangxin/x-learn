package cn.xin.learn.design.creational.builder.biz;

import cn.xin.learn.design.creational.builder.core.UserBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tiancx
 * @description: 用户-建造者模式
 * @date 2024年07月18日
 */
@Data
@AllArgsConstructor
public class User {
    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public static UserBuilder builder(){
        return new UserBuilder();
    }

}
