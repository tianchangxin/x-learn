package cn.xin.learn.community.entity.dto.permissions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 权限DTO
 * @date 2024年12月29日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDto {
    //权限ID
    private Long permissionId;
    //用户Id
    private Long userId;
    //页面名称
    private String pageName;
    //权限类型（增删改查）
    private String type;

}
