package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.task.TaskDto;
import cn.xin.learn.community.entity.dto.usercomment.UserCommentTemplateDto;
import cn.xin.learn.community.entity.params.task.QueryTaskParam;
import cn.xin.learn.community.entity.params.task.SaveOrUpdateTaskParam;
import cn.xin.learn.community.entity.params.usercomment.SaveOrUpdateUserCommentParam;
import cn.xin.learn.community.entity.po.Task;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 任务;(Task)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @RequestMapping("listTaskInfo")
    public PageVo<TaskDto> queryTaskInfo(@RequestBody QueryTaskParam queryTaskParam){
        return taskService.queryTaskInfo(queryTaskParam);
    }


    @RequestMapping("saveOrUpdateTask")
    public Boolean saveOrUpdateTask(@RequestBody SaveOrUpdateTaskParam taskParam){
        return taskService.saveOrUpdateTaskInfo(taskParam);
    }

    @RequestMapping("deleteTask")
    public Boolean deleteTask(@RequestBody Integer taskId){
        return taskService.deleteTaskInfo(taskId);
    }



}

