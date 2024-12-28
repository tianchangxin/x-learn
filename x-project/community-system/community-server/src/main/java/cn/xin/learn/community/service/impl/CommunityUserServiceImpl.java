package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.CommunityUserDao;
import cn.xin.learn.community.entity.params.PageUserParams;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.CommunityUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 社区用户表;(CommunityUser)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:22
 */
@Service("communityUserService")
public class CommunityUserServiceImpl extends ServiceImpl<CommunityUserDao, CommunityUser> implements CommunityUserService {

    /**
     * 新增或者修改用户
     *
     * @param communityUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOrUpdateUser(CommunityUser communityUser) {
        return this.saveOrUpdate(communityUser);
    }

    /**
     * 查询用户列表
     *
     * @param pageUserParams 分页参数
     * @return 用户列表
     */
    @Override
    public PageVo<CommunityUser> queryUserList(PageUserParams pageUserParams) {
        //分页查询
        Page<CommunityUser> page = new Page<>();
        page.setCurrent(pageUserParams.getCurrentPage());
        page.setSize(pageUserParams.getPageSize());
        Page<CommunityUser> userPage = this.page(page);
        List<CommunityUser> records = userPage.getRecords();
        return PageVo.<CommunityUser>builder()
                .items(records)
                .totalElement(userPage.getTotal())
                .totalPage(userPage.getPages())
                .build();
    }
}

