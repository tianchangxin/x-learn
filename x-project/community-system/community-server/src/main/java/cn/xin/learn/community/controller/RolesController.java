package cn.xin.learn.community.controller;

import cn.xin.learn.community.entity.dto.roles.RolesDto;
import cn.xin.learn.community.entity.params.roles.PageRolesParam;
import cn.xin.learn.community.entity.params.roles.SaveUpdateRoleParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 角色;(Roles)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RolesController {
    private final RolesService rolesService;

    /**
     * 新增或者修改角色
     */
    @PostMapping("saveOrUpdateRoles")
    public Boolean saveOrUpdateRoles(@Validated @RequestBody SaveUpdateRoleParam params) {
        return rolesService.saveOrUpdateRoles(params);
    }

    /**
     * 查看角色列表
     */
    @PostMapping("listRoles")
    public PageVo<RolesDto> listRoles(@RequestBody PageRolesParam pageRolesParam) {
        return rolesService.queryRolesList(pageRolesParam);
    }

}

