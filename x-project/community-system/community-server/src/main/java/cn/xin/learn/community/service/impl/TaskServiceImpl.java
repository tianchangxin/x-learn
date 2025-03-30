package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;



import cn.hutool.json.JSONUtil;
import cn.xin.learn.community.dao.TaskDao;
import cn.xin.learn.community.entity.dto.task.TaskDto;
import cn.xin.learn.community.entity.dto.usercomment.UserCommentTemplateDto;
import cn.xin.learn.community.entity.params.task.QueryTaskParam;
import cn.xin.learn.community.entity.params.task.SaveOrUpdateTaskParam;
import cn.xin.learn.community.entity.params.usercomment.SaveOrUpdateUserCommentParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.po.Task;
import cn.xin.learn.community.entity.po.UserCommentTemplate;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.helpers.UserHelper;
import cn.xin.learn.community.service.CommunityUserService;
import cn.xin.learn.community.service.TaskService;
import cn.xin.learn.community.service.UserCommentTemplateService;
import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 任务;(Task)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:28
 */
@Service("taskService")
public class TaskServiceImpl extends ServiceImpl<TaskDao, Task> implements TaskService {

    @Autowired
    private UserCommentTemplateService userCommentTemplateService;

    @Autowired
    private CommunityUserService communityUserService;

    @Autowired
    private TaskDao taskDao;


    /**
     * 根据人物名模糊查询，或者根据任务状态、任务类型分页查询
     * @param taskParam 查询参数
     * @return 查询结果
     */
    @Override
    public PageVo<TaskDto> queryTaskInfo(QueryTaskParam taskParam){
        CommunityUser communityUser=new CommunityUser();
        if(Objects.nonNull(taskParam.getUserId())){
             communityUser = communityUserService.getById(taskParam.getUserId());
        }
        LambdaQueryWrapper<Task> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Objects.nonNull(taskParam.getTaskName()),Task::getTaskName,taskParam.getTaskName())
                .eq(Objects.nonNull(taskParam.getTaskType()),Task::getTaskType,taskParam.getTaskType())
                .eq(Objects.nonNull(taskParam.getTaskStatus()),Task::getTaskStatus,taskParam.getTaskStatus())
                .orderByDesc(Task::getTaskId)
                .eq(Objects.nonNull(taskParam.getUserId()),Task::getExecutor,communityUser.getUserName());
        Page<Task> page = Page.of(taskParam.getCurrentPage(), taskParam.getPageSize());
        page = this.page(page, wrapper);
        List<TaskDto> taskDtos = BeanUtil.copyToList(page.getRecords(), TaskDto.class);
        PageVo<TaskDto> pageVo = PageVo.<TaskDto>builder()
                .items(taskDtos)
                .totalElement(this.count(wrapper))
                .totalPage(page.getPages())
                .build();
        return pageVo;
    }


    @Override
    public Boolean saveOrUpdateTaskInfo(SaveOrUpdateTaskParam taskParam){
        Task task = new Task();
        BeanUtil.copyProperties(taskParam,task);
        task.setTemplateId(taskParam.getTemplateId());
        //新增
        if(Objects.isNull(task.getTaskId())){
            task.setTaskStatus(0);
            return taskDao.insertTask(task);
        }
        // 编辑
        else{
            return this.updateById(task);
        }
    }

    @Override
    public Boolean deleteTaskInfo(Integer taskId){
        return this.removeById(taskId);
    }



}

