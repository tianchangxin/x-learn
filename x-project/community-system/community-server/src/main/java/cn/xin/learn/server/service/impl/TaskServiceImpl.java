package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.TaskDao;
import cn.xin.learn.server.entity.po.Task;
import cn.xin.learn.server.service.TaskService;
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

