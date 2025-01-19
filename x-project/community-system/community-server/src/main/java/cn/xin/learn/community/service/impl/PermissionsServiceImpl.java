package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.PermissionsDao;
import cn.xin.learn.community.entity.dto.permissions.PermissionDto;
import cn.xin.learn.community.entity.params.permission.PagePermissionParam;
import cn.xin.learn.community.entity.params.permission.QueryPermissionParam;
import cn.xin.learn.community.entity.params.permission.SaveUpdatePermissionParam;
import cn.xin.learn.community.entity.po.Permissions;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.service.PermissionsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 权限表;(Permissions)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:26
 */
@Service("permissionsService")
public class PermissionsServiceImpl extends ServiceImpl<PermissionsDao, Permissions> implements PermissionsService {

    /**
     * 保存或更新权限
     *
     * @param param 权限参数
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOrUpdatePermissions(SaveUpdatePermissionParam param) {
        List<String> types = param.getTypes();
        List<Permissions> list = types.stream().map(type -> {
            Permissions permissions = new Permissions();
            //复制属性
            BeanUtil.copyProperties(param, permissions);
            permissions.setType(type);
            return permissions;
        }).toList();
        return saveOrUpdateBatch(list);
    }

    /**
     * 分页查询权限
     *
     * @param param 分页和过滤参数
     * @return 权限列表
     */
    @Override
    public PageVo<PermissionDto> listPermissions(PagePermissionParam param) {
        LambdaQueryWrapper<Permissions> wrapper = new LambdaQueryWrapper<Permissions>()
                .eq(Objects.nonNull(param.getPermissionId()), Permissions::getPermissionId, param.getPermissionId())
                .eq(Objects.nonNull(param.getUserId()), Permissions::getUserId, param.getUserId())
                .like(StringUtils.isNotEmpty(param.getPageName()), Permissions::getPageName, param.getPageName())
                .eq(StringUtils.isNotEmpty(param.getType()), Permissions::getType, param.getType());
        Permissions permissions = new Permissions();
        //复制属性
        BeanUtil.copyProperties(param, permissions);
        Page<Permissions> page = Page.of(param.getCurrentPage(), param.getPageSize());
        page = page(page, wrapper);
        List<PermissionDto> permissionDtos = BeanUtil.copyToList(page.getRecords(), PermissionDto.class);
        return PageVo.<PermissionDto>builder()
                .items(permissionDtos)
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .build();
    }

    /**
     * 根据权限id获取权限
     *
     * @param permissionId 权限id
     * @return 权限
     */
    @Override
    public PermissionDto getPermissionById(Long permissionId) {
        CommunityAssert.notNull(permissionId, "权限id不能为空");
        Permissions permissions = getById(permissionId);
        return BeanUtil.copyProperties(permissions, PermissionDto.class);
    }

    /**
     * 用户权限列表
     *
     * @param param 用户id
     * @return 权限列表
     */
    @Override
    public List<PermissionDto> listUserPermissions(QueryPermissionParam param) {
        CommunityAssert.notNull(param, "查询参数不能为空");
        LambdaQueryWrapper<Permissions> wrapper = new LambdaQueryWrapper<Permissions>()
                .eq(Objects.nonNull(param.getUserId()), Permissions::getUserId, param.getUserId())
                .eq(StringUtils.isNotEmpty(param.getPageName()), Permissions::getPageName, param.getPageName())
                .eq(StringUtils.isNotEmpty(param.getType()), Permissions::getType, param.getType());
        List<Permissions> permissions = list(wrapper);
        return BeanUtil.copyToList(permissions, PermissionDto.class);
    }

    /**
     * 删除权限
     *
     * @param permissionIds 权限id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deletePermission(List<Long> permissionIds) {
        CommunityAssert.notNull(permissionIds, "权限id不能为空");
        return removeBatchByIds(permissionIds);
    }
}

