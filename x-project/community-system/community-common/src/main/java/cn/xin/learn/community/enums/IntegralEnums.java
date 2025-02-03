package cn.xin.learn.community.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xin
 * @description: 积分枚举
 * @date 2025年02月03日
 */
@Getter
@AllArgsConstructor
public enum IntegralEnums {
    //使用
    USE(0, "使用"),
    //新增
    ADD(1, "新增");

    private final Integer code;
    private final String desc;

}
