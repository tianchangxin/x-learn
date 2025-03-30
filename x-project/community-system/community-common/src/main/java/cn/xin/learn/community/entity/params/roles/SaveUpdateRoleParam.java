package cn.xin.learn.community.entity.params.roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author xin
 * @description: 保存或者更新角色参数
 * @date 2024年12月29日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class SaveUpdateRoleParam {
    //角色ID（新增时不传，修改时传）
    private Long roleId;
    //角色名称
    @NotEmpty(message = "角色名称不能为空")
    private String roleName;
    //角色状态（0-禁用，1-启用）
    @NotNull(message = "角色状态不能为空")
    private Integer roleStatus;
}
