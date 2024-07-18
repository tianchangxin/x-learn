package cn.xin.learn.design.creational.builder.biz;

import lombok.Data;

/**
 * @author tiancx
 * @description: 用户-建造者模式
 * @date 2024年07月18日
 */
@Data
public class User {
    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    public static User builder(){
        return new User();
    }

    public User name(String name){
        this.name = name;
        return this;
    }

    public User age(Integer age){
        this.age = age;
        return this;
    }

    public User build(){
        return this;
    }

}
