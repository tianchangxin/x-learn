package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 任务;(Task)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class Task extends BasePo {
    //任务ID
    @TableId(type = IdType.AUTO)
    private Integer taskId;
    //任务名称
    private String taskName;
    //任务类型
    private Integer taskType;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //部门Id
    private Integer deptId;
    //部门名称
    private String deptName;
    //执行人
    private String executor;
    //领域类型
    private Integer domainType;
    //任务状态（0-创建、1-执行中、2-完成）
    private Integer taskStatus;
    //任务内容
    private String taskContent;

    @TableField("template_id")
    //模板id
    private Long templateId;
}

