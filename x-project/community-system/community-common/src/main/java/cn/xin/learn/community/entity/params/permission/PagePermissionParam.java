package cn.xin.learn.community.entity.params.permission;

import cn.xin.learn.community.entity.params.PageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 分页查询权限参数
 * @date 2024年12月29日
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagePermissionParam extends PageParam {
    //权限ID
    private Long permissionId;
    //用户Id
    private Long userId;
    //页面名称
    private String pageName;
    //权限类型（增删改查）
    private String type;
}
