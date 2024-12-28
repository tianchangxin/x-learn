package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * ;(Department)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
@SuppressWarnings("serial")
public class Department extends BasePo {
    //组织id
    @TableId
    private Integer deptId;
    //部门名称
    private String deptName;
    //父部门id
    private Integer deptParentId;
    //父部门名称
    private String deptParentName;
}

