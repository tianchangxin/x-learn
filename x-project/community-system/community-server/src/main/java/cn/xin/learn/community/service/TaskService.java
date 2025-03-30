package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.task.TaskDto;
import cn.xin.learn.community.entity.dto.usercomment.UserCommentTemplateDto;
import cn.xin.learn.community.entity.params.task.QueryTaskParam;
import cn.xin.learn.community.entity.params.task.SaveOrUpdateTaskParam;
import cn.xin.learn.community.entity.params.usercomment.SaveOrUpdateUserCommentParam;
import cn.xin.learn.community.entity.po.Task;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 任务;(Task)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:28
 */
public interface TaskService extends IService<Task> {

    PageVo<TaskDto> queryTaskInfo(QueryTaskParam taskParam);


    Boolean saveOrUpdateTaskInfo(SaveOrUpdateTaskParam taskParam);

    Boolean deleteTaskInfo(Integer taskId);
}

