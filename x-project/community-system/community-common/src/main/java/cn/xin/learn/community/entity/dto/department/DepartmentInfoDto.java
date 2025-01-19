package cn.xin.learn.community.entity.dto.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xin
 * @description: 部门DTO
 * @date 2025年01月18日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInfoDto {
    //组织id
    private Long deptId;
    //部门名称
    private String deptName;
    //父部门id
    private Long deptParentId;
    //父部门名称
    private String deptParentName;
    //子部门
    private List<DepartmentInfoDto> children;
}
