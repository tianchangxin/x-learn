package cn.xin.learn.community.entity.params.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 查询部门参数
 * @date 2025年01月18日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDepartmentParam {
    //组织id
    private Long deptId;
    //部门名称
    private String deptName;
    //父部门id
    private Long deptParentId;
    //父部门名称
    private String deptParentName;
}
