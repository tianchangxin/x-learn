package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.CommunityDao;
import cn.xin.learn.server.entity.po.Community;
import cn.xin.learn.server.service.CommunityService;
import org.springframework.stereotype.Service;

/**
 * 社区信息表;(Community)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@Service("communityService")
public class CommunityServiceImpl extends ServiceImpl<CommunityDao, Community> implements CommunityService {

}

