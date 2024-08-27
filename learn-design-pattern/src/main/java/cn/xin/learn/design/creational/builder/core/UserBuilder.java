package cn.xin.learn.design.creational.builder.core;

import cn.xin.learn.design.creational.builder.biz.User;
import lombok.Data;

/**
 * @author tiancx
 * @description: 用户-建造者模式
 * @date 2024年07月18日
 */
@Data
public class UserBuilder {
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

    public UserBuilder name(String name){
        this.name = name;
        return this;
    }

    public UserBuilder age(Integer age){
        this.age = age;
        return this;
    }

    public User build(){
        return new User(this.name, this.age);
    }

}
