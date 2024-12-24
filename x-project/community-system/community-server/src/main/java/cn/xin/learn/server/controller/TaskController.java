package cn.xin.learn.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xin.learn.server.entity.po.Task;
import cn.xin.learn.server.service.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 任务;(Task)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@RestController
@RequestMapping("task")
public class TaskController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TaskService taskService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param task 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Task> page, Task task) {
        return success(this.taskService.page(page, new QueryWrapper<>(task)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.taskService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param task 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Task task) {
        return success(this.taskService.save(task));
    }

    /**
     * 修改数据
     *
     * @param task 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Task task) {
        return success(this.taskService.updateById(task));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.taskService.removeByIds(idList));
    }
}

