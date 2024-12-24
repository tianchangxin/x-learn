package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.DepartmentDao;
import cn.xin.learn.server.entity.po.Department;
import cn.xin.learn.server.service.DepartmentService;
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

