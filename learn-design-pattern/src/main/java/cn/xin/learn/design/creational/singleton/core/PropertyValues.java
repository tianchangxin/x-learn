package cn.xin.learn.design.creational.singleton.core;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tiancx
 * @description: 属性值集合
 * @date 2024年07月20日
 */
@Data
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();
    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

}
