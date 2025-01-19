package cn.xin.learn.community.entity.dto.roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 角色DTO
 * @date 2024年12月29日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesDto {
    //角色ID
    private Integer roleId;
    //角色名称
    private String roleName;
    //角色状态（0-禁用，1-启用）
    private Integer roleStatus;
}
