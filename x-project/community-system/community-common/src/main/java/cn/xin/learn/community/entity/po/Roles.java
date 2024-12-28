package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 角色;(Roles)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@SuppressWarnings("serial")
public class Roles extends BasePo {
    //角色ID
    @TableId
    private Integer roleId;
    //角色名称
    private String roleName;
    //角色状态（0-禁用，1-启用）
    private Integer roleStatus;

}

