package cn.xin.learn.community.entity.params.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author xin
 * @description: 保存或更新部门参数
 * @date 2025年01月18日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUpdateDepartmentParam {
    //组织id(新增时不传，更新时传)
    private Long deptId;
    //部门名称
    @NotEmpty(message = "部门名称不能为空")
    private String deptName;
    //父部门id(顶级部门传0)
    @NotNull(message = "父部门id不能为空")
    private Long deptParentId;
    //父部门名称(顶级部门传顶级部门)
    @NotEmpty(message = "父部门名称不能为空")
    private String deptParentName;
}
