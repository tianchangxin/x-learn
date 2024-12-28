package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.PermissionsDao;
import cn.xin.learn.community.entity.po.Permissions;
import cn.xin.learn.community.service.PermissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

