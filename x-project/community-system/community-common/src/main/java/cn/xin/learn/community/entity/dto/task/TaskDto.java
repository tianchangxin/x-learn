package cn.xin.learn.community.entity.dto.task;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title: TaskDto
 * @Author yinan
 * @Package cn.xin.learn.community.entity.dto.task
 * @Date 2025/1/20 14:41
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    //任务ID
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
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //创建用户
    private String createUser;
    //修改用户
    private String updateUser;
}
