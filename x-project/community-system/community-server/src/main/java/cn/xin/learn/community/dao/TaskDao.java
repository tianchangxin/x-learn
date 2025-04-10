package cn.xin.learn.community.dao;

import cn.xin.learn.community.entity.po.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 任务;(Task)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@Mapper
public interface TaskDao extends BaseMapper<Task> {

    Boolean insertTask(Task task);

}

