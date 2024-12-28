package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.TaskDao;
import cn.xin.learn.community.entity.po.Task;
import cn.xin.learn.community.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 任务;(Task)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:28
 */
@Service("taskService")
public class TaskServiceImpl extends ServiceImpl<TaskDao, Task> implements TaskService {

}

