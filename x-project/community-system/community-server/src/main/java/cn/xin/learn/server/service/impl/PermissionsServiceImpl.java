package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.PermissionsDao;
import cn.xin.learn.server.entity.po.Permissions;
import cn.xin.learn.server.service.PermissionsService;
import org.springframework.stereotype.Service;

/**
 * 权限表;(Permissions)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:26
 */
@Service("permissionsService")
public class PermissionsServiceImpl extends ServiceImpl<PermissionsDao, Permissions> implements PermissionsService {

}

