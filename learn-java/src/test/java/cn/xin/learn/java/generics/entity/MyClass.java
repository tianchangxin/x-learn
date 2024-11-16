package cn.xin.learn.java.generics.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tiancx
 * @description: 测试使用类
 * @date 2024年11月14日
 */
public class MyClass {
    public List<String> getList() {
        return new ArrayList<>();
    }

    public Integer intTest(Integer integer) {
        return 1;
    }

    public Integer strIntTest(String string, Integer integer) {
        return 1;
    }
}
