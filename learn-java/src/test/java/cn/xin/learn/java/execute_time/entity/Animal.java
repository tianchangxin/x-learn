package cn.xin.learn.java.execute_time.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xin
 * @description: 动物父类
 * @date 2025年03月01日
 */
@Slf4j
public class Animal {
    private static final String TAG = tag();

    {
        log.info("Animal类初始化块");
    }

    static {
        log.info("Animal类静态初始化块");
    }

    public static String tag() {
        log.info("Animal类静态方法-tag");
        return "";
    }

    public Animal() {
        log.info("Animal类构造方法");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
    }
}
