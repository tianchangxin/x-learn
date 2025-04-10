package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.RolesDao;
import cn.xin.learn.community.entity.dto.roles.RolesDto;
import cn.xin.learn.community.entity.params.roles.PageRolesParam;
import cn.xin.learn.community.entity.params.roles.SaveUpdateRoleParam;
import cn.xin.learn.community.entity.po.Roles;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.service.RolesService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 角色;(Roles)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@Service("rolesService")
public class RolesServiceImpl extends ServiceImpl<RolesDao, Roles> implements RolesService {

    /**
     * 新增或者修改角色
     *
     * @param param 角色信息
     * @return 是否新增或者修改成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOrUpdateRoles(SaveUpdateRoleParam param) {
        //todo 校验当前用户是否有权限
        Roles roles = BeanUtil.copyProperties(param, Roles.class);
        return this.saveOrUpdate(roles);
    }

    /**
     * 查看角色列表
     *
     * @param pageRolesParam 分页参数
     * @return 角色列表
     */
    @Override
    public PageVo<RolesDto> queryRolesList(PageRolesParam pageRolesParam) {
        Roles roles = new Roles();
        BeanUtils.copyProperties(pageRolesParam, roles);
        LambdaQueryWrapper<Roles> wrapper = new LambdaQueryWrapper<Roles>()
                .eq(Objects.nonNull(roles.getRoleId()), Roles::getRoleId, roles.getRoleId())
                .like(StringUtils.isNotEmpty(roles.getRoleName()), Roles::getRoleName, roles.getRoleName())
                .eq(Objects.nonNull(roles.getRoleStatus()), Roles::getRoleStatus, roles.getRoleStatus());
        Page<Roles> page = Page.of(pageRolesParam.getCurrentPage(), pageRolesParam.getPageSize());
        Page<Roles> pageRes = this.page(page, wrapper);
        return PageVo.<RolesDto>builder()
                .items(BeanUtil.copyToList(pageRes.getRecords(), RolesDto.class))
                .totalElement(pageRes.getTotal())
                .totalPage(pageRes.getPages())
                .build();
    }

    /**
     * 删除角色
     *
     * @param roleIds 角色ID集合
     * @return 是否删除成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteRoles(List<Long> roleIds) {
        //校验
        CommunityAssert.notEmpty(roleIds, "角色ID不能为空");
        return this.removeByIds(roleIds);
    }
}

