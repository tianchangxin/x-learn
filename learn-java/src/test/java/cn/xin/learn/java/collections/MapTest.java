package cn.xin.learn.java.collections;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author tiancx
 * @description: HashMap测试类
 * @date 2024年12月11日
 */
@Slf4j
public class MapTest {

    /**
     * 测试是否抛异常
     */
    @Test
    public void testNullException() {
        Map<String, String> map = new HashMap<>();
        String s = map.get(null);
        Assert.equals(s, null);
        String s1 = map.get("1");
        Assert.equals(s1, null);
    }

    /**
     * 测试map的Api
     */
    @Test
    public void testMapApi() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        String s = map.get("1");
        Assert.equals(s, "1");
        //如果键不存在，则返回默认值
        String number = map.getOrDefault("1", "3");
        Assert.equals(number, "1");
        String number1 = map.getOrDefault("3", "3");
        Assert.equals(number1, "3");
    }

    /**
     * 测试map的putIfAbsent
     *
     * @description: 键不存在，则添加键值对，并返回null，键存在，则返回键对应的值
     */
    @Test
    public void testPutIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        String s = map.putIfAbsent("2", "5");
        Assert.equals(s, "2");
        String s1 = map.putIfAbsent("3", "6");
        Assert.equals(s1, null);
        String s2 = map.get("3");
        Assert.equals(s2, "6");

    }

    /**
     * 测试computeIfAbsent
     *
     * @description: 如果该键不存在，则使用指定的函数计算出一个默认值并将其存储到Map中，最后返回该默认值‌
     */
    @Test
    public void testComputeIfAbsent() {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("1", Arrays.asList(1, 2, 3));
        map.put("2", Arrays.asList(4, 5, 6));
        List<Integer> list = map.computeIfAbsent("1", x -> {
            return new ArrayList<>();
        });
        Assert.equals(list.size(), 3);
    }
}
