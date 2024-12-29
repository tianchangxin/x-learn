package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.permissions.PermissionDto;
import cn.xin.learn.community.entity.params.permission.PagePermissionParam;
import cn.xin.learn.community.entity.params.permission.QueryPermissionParam;
import cn.xin.learn.community.entity.params.permission.SaveUpdatePermissionParam;
import cn.xin.learn.community.entity.po.Permissions;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 权限表;(Permissions)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:26
 */
public interface PermissionsService extends IService<Permissions> {
    /**
     * 保存或更新权限
     *
     * @param param 权限参数
     * @return 是否成功
     */
    Boolean saveOrUpdatePermissions(SaveUpdatePermissionParam param);

    /**
     * 分页查询权限
     *
     * @param param 分页和过滤参数
     * @return 权限列表
     */
    PageVo<PermissionDto> listPermissions(PagePermissionParam param);

    /**
     * 根据权限id获取权限
     *
     * @param permissionId 权限id
     * @return 权限
     */
    PermissionDto getPermissionById(Long permissionId);

    /**
     * 用户权限列表
     *
     * @param param 查询参数
     * @return 权限列表
     */
    List<PermissionDto> listUserPermissions(QueryPermissionParam param);

    /**
     * 删除权限
     *
     * @param permissionIds 权限ids
     */
    Boolean deletePermission(List<Long> permissionIds);
}

