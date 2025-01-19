package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.department.DepartmentInfoDto;
import cn.xin.learn.community.entity.params.department.SaveUpdateDepartmentParam;
import cn.xin.learn.community.entity.po.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * ;(Department)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
public interface DepartmentService extends IService<Department> {

    /**
     * 新增或者修改部门
     */
    Boolean saveOrUpdateDepartment(SaveUpdateDepartmentParam param);

    /**
     * 删除部门(会删除子部门)
     */
    Boolean deleteDepartment(Long deptId);

    /**
     * 查询部门元数据
     */
    List<DepartmentInfoDto> queryDepartmentList();
}

