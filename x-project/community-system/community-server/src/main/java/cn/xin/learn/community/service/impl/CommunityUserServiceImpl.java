package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.CommunityUserDao;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.service.CommunityUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 社区用户表;(CommunityUser)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:22
 */
@Service("communityUserService")
public class CommunityUserServiceImpl extends ServiceImpl<CommunityUserDao, CommunityUser> implements CommunityUserService {

}

