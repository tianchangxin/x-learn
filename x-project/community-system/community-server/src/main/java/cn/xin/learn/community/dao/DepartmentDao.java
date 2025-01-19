package cn.xin.learn.community.dao;

import cn.xin.learn.community.entity.dto.department.DepartmentInfoDto;
import cn.xin.learn.community.entity.po.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * ;(Department)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
public interface DepartmentDao extends BaseMapper<Department> {

    /**
     * 查询部门元数据
     */
    List<DepartmentInfoDto> queryDepartmentList();

}

