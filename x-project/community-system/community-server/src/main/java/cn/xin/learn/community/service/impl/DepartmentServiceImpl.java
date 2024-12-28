package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.DepartmentDao;
import cn.xin.learn.community.entity.po.Department;
import cn.xin.learn.community.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ;(Department)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, Department> implements DepartmentService {

}

