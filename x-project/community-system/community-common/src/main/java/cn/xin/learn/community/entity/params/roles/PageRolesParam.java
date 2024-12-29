package cn.xin.learn.community.entity.params.roles;

import cn.xin.learn.community.entity.params.PageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 分页查询角色参数
 * @date 2024年12月29日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRolesParam extends PageParam {

    //角色ID
    private Integer roleId;
    //角色名称
    private String roleName;
    //角色状态（0-禁用，1-启用）
    private Integer roleStatus;
}
