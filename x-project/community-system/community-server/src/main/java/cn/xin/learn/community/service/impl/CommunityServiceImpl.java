package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.CommunityDao;
import cn.xin.learn.community.entity.po.Community;
import cn.xin.learn.community.service.CommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

