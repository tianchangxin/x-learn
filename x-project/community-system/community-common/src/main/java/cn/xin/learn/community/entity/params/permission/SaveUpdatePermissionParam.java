package cn.xin.learn.community.entity.params.permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xin
 * @description: 保存更新权限参数
 * @date 2024年12月29日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUpdatePermissionParam {
    //权限ID（新增时不传，修改时传）
    private Long permissionId;
    //用户Id
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    //页面名称
    @NotEmpty(message = "页面名称不能为空")
    private String pageName;
    //权限类型（增删改查）
    @NotEmpty(message = "权限类型不能为空")
    private List<String> types;
}
