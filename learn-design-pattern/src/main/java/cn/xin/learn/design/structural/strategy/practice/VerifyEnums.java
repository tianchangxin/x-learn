package cn.xin.learn.design.structural.strategy.practice;

import lombok.Getter;

/**
 * @author tiancx
 * @description: 验证类型枚举
 * @date 2024年11月16日
 */
@Getter
public enum VerifyEnums {
    /**
     * 手机验证码
     */
    PHONE("phone", "手机验证码"),
    /**
     * 密保问题验证
     */
    CONFIDENTIAL("confidential", "密保问题验证");

    private final String type;

    private final String desc;

    VerifyEnums(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
