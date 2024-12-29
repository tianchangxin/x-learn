package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.permissions.PermissionDto;
import cn.xin.learn.community.entity.params.permission.PagePermissionParam;
import cn.xin.learn.community.entity.params.permission.QueryPermissionParam;
import cn.xin.learn.community.entity.params.permission.SaveUpdatePermissionParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.PermissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 权限表;(Permissions)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@RestController
@RequestMapping("permissions")
@RequiredArgsConstructor
public class PermissionsController {
    private final PermissionsService permissionsService;

    /**
     * 保存或更新权限
     */
    @PostMapping("saveOrUpdate")
    public Boolean saveOrUpdate(@RequestBody SaveUpdatePermissionParam param) {
        return permissionsService.saveOrUpdatePermissions(param);
    }

    /**
     * 分页查询权限
     */
    @PostMapping("list")
    public PageVo<PermissionDto> list(@RequestBody PagePermissionParam param) {
        return permissionsService.listPermissions(param);
    }

    /**
     * 根据权限id获取权限
     */
    @GetMapping("get")
    public PermissionDto get(Long permissionId) {
        return permissionsService.getPermissionById(permissionId);
    }

    /**
     * 用户权限列表
     */
    @GetMapping("listUser")
    public List<PermissionDto> listUser(QueryPermissionParam param) {
        return permissionsService.listUserPermissions(param);
    }

    /**
     * 删除权限
     */
    @PostMapping("delete")
    public Boolean delete(@RequestBody List<Long> permissionIds) {
        return permissionsService.deletePermission(permissionIds);
    }
}

