package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 权限表;(Permissions)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:26
 */
@SuppressWarnings("serial")
public class Permissions extends BasePo {
    //自增id
    @TableId
    private Integer permissionId;
    //用户Id
    private Integer userId;
    //页面名称
    private String pageName;
    //权限类型（增删改查）
    private String type;

}

