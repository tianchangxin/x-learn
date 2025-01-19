package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * ;(Department)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
@Data
@SuppressWarnings("serial")
public class Department extends BasePo {
    //组织id
    @TableId
    private Long deptId;
    //部门名称
    private String deptName;
    //父部门id
    private Long deptParentId;
    //父部门名称
    private String deptParentName;
}

