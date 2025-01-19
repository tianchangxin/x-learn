package cn.xin.learn.community.entity.params;

import lombok.Data;

import java.util.Date;

/**
 * @author xin
 * @description: 基础实体类
 * @date 2024年12月28日
 */
@Data
public class BaseParam {
    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    //创建用户
    private String createUser;

    //修改用户
    private String updateUser;

    //是否删除（0-未删除，1-删除）
    private Integer isDelete;
}
