package cn.xin.learn.design.creational.singleton.core;

import lombok.Data;

/**
 * @author tiancx
 * @description: 属性值-包装一个对象的PropertyValue
 * @date 2024年07月20日
 */
@Data
public class PropertyValue {
    private final String name;
    private final Object value;
}
