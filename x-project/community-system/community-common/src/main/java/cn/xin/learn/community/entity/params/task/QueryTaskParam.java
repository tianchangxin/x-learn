package cn.xin.learn.community.entity.params.task;

import cn.xin.learn.community.entity.params.PageParam;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title: QueryTaskParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.task
 * @Date 2025/1/20 14:50
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryTaskParam extends PageParam {
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
    //任务状态（0-创建、1-执行中、2-完成）
    private Integer taskStatus;
    //用户ID
    private Integer userId;
}
