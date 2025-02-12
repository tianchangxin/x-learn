package cn.xin.learn.community.entity.params.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Title: SaveOrUpdateTaskParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.task
 * @Date 2025/1/20 15:07
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class SaveOrUpdateTaskParam {
    //任务ID(新增时不传，修改时传)
    private Integer taskId;
    //任务名称
    @NotEmpty(message = "任务名称不能为空")
    private String taskName;
    //任务类型
    @NotEmpty(message = "任务类型不能为空")
    private Integer taskType;
    //开始时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @NotNull(message = "开始时间不能为空")
    private Date startTime;
    //结束时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @NotNull(message = "结束时间不能为空")
    private Date endTime;
    //任务内容
    private String taskContent;
    //部门Id
    @NotEmpty(message = "部门Id不能为空")
    private Integer deptId;
    //部门名称
    @NotEmpty(message = "部门名称不能为空")
    private String deptName;
    //领域类型
    private Integer domainType;
    //评价模版ID
    private Long templateId;
}
