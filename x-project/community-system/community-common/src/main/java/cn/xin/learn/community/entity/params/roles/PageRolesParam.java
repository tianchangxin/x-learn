package cn.xin.learn.community.entity.params.roles;

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
public class PageRolesParam {
    //当前页
    private Integer currentPage;
    //每页显示条数
    private Integer pageSize;

    //角色ID
    private Integer roleId;
    //角色名称
    private String roleName;
    //角色状态（0-禁用，1-启用）
    private Integer roleStatus;
}
