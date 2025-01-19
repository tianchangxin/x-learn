package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.DepartmentDao;
import cn.xin.learn.community.entity.dto.department.DepartmentInfoDto;
import cn.xin.learn.community.entity.params.department.SaveUpdateDepartmentParam;
import cn.xin.learn.community.entity.po.Department;
import cn.xin.learn.community.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ;(Department)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, Department> implements DepartmentService {

    /**
     * 新增或者修改部门
     *
     * @param param 部门信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveOrUpdateDepartment(SaveUpdateDepartmentParam param) {
        Department department = BeanUtil.copyProperties(param, Department.class);
        return this.saveOrUpdate(department);
    }

    /**
     * 删除部门(会删除子部门)
     *
     * @param deptId
     */
    @Override
    public Boolean deleteDepartment(Long deptId) {
        //todo 需要删除子部门
        return null;
    }

    /**
     * 查询部门元数据
     */
    @Override
    public List<DepartmentInfoDto> queryDepartmentList() {
        return this.getBaseMapper().queryDepartmentList();
    }
}

