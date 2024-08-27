package com.ztc.learn.mybatis.modle.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 性别 0-女,1-男
     */
    private Integer sex;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 角色(1-管理员,2-用户)
     */
    private String role;
}
