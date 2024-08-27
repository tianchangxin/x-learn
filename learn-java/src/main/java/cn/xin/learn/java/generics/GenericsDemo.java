package cn.xin.learn.java.generics;

import java.util.List;
import java.util.Map;

/**
 * @author tiancx
 * @description: 泛型测试
 * @date 2024年08月16日
 */
public class GenericsDemo<T extends Number> {
    private T t;

    private List<T> list;

    private Map<String, T> map;
}
