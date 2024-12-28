package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.params.PageUserParams;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 社区用户表;(CommunityUser)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:22
 */
public interface CommunityUserService extends IService<CommunityUser> {
    /**
     * 新增或者修改用户
     */
    Boolean saveOrUpdateUser(CommunityUser communityUser);

    /**
     * 查询用户列表
     */
    PageVo<CommunityUser> queryUserList(PageUserParams pageUserParams);
}

