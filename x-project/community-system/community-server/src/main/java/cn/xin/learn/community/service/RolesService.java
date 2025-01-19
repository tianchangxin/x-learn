package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.roles.RolesDto;
import cn.xin.learn.community.entity.params.roles.PageRolesParam;
import cn.xin.learn.community.entity.params.roles.SaveUpdateRoleParam;
import cn.xin.learn.community.entity.po.Roles;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色;(Roles)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
public interface RolesService extends IService<Roles> {
    /**
     * 新增或者修改角色
     *
     * @param param 角色信息
     * @return 是否新增或者修改成功
     */
    Boolean saveOrUpdateRoles(SaveUpdateRoleParam param);

    /**
     * 查看角色列表
     *
     * @param pageRolesParam 分页参数
     * @return 角色列表
     */
    PageVo<RolesDto> queryRolesList(PageRolesParam pageRolesParam);

    /**
     * 删除角色
     *
     * @param roleIds 角色ID集合
     * @return 是否删除成功
     */
    Boolean deleteRoles(List<Long> roleIds);
}

