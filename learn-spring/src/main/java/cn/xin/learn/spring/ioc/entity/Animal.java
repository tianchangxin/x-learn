package cn.xin.learn.spring.ioc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author tiancx
 */

public class Animal {
    @JsonProperty("Name")
    private String name;

    public Animal() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

}
