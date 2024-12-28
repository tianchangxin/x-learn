package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.RolesDao;
import cn.xin.learn.community.entity.po.Roles;
import cn.xin.learn.community.service.RolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色;(Roles)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@Service("rolesService")
public class RolesServiceImpl extends ServiceImpl<RolesDao, Roles> implements RolesService {

}

