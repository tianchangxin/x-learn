package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 角色;(Roles)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@SuppressWarnings("serial")
@Data
public class Roles extends BasePo {
    //角色ID
    @TableId(type = IdType.AUTO)
    private Integer roleId;
    //角色名称
    private String roleName;
    //角色状态（0-禁用，1-启用）
    private Integer roleStatus;

}

