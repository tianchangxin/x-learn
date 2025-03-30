package cn.xin.learn.community.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xin
 * @description: 角色枚举
 * @date 2024年12月29日
 */
@Getter
@AllArgsConstructor
public enum RolesEnum {
    //超级管理员
    SUPER_ADMIN(1),
    //普通用户
    REGULAR_USER(2);
    private final Integer code;

}
