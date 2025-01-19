package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.department.DepartmentInfoDto;
import cn.xin.learn.community.entity.params.department.SaveUpdateDepartmentParam;
import cn.xin.learn.community.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ;(Department)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
@RestController
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    /**
     * 新增或者修改部门
     */
    @PostMapping("saveOrUpdateDepartment")
    public Boolean saveOrUpdateDepartment(@Validated @RequestBody SaveUpdateDepartmentParam param) {
        return departmentService.saveOrUpdateDepartment(param);
    }

    /**
     * 查看部门元数据
     */
    @PostMapping("queryDepartmentList")
    public List<DepartmentInfoDto> queryDepartmentList() {
        return departmentService.queryDepartmentList();
    }


}

