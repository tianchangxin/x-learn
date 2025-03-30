package cn.xin.learn.java.execute_time.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xin
 * @description: 🐱
 * @date 2025年03月01日
 */
@Slf4j
public class Cat extends Animal {
    private static final String TAG = tag();

    {
        log.info("Cat类初始化块");
    }

    static {
        log.info("Cat类静态初始化块");
    }

    public static String tag() {
        log.info("Cat类静态方法-tag");
        return "";
    }
    

    public Cat() {
        log.info("Cat类构造方法");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat cat1 = new Cat();
    }
}
