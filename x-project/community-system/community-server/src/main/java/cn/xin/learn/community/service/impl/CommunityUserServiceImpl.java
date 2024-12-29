package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.CommunityUserDao;
import cn.xin.learn.community.entity.params.user.PageUserParam;
import cn.xin.learn.community.entity.params.user.SaveUpdateUserParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.CommunityUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
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
     * @param param 用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOrUpdateUser(SaveUpdateUserParam param) {
        CommunityUser communityUser = new CommunityUser();
        BeanUtils.copyProperties(param, communityUser);
        return this.saveOrUpdate(communityUser);
    }

    /**
     * 查询用户列表
     *
     * @param pageUserParam 分页参数
     * @return 用户列表
     */
    @Override
    public PageVo<CommunityUser> queryUserList(PageUserParam pageUserParam) {
        //分页查询
        Page<CommunityUser> page = new Page<>();
        page.setCurrent(pageUserParam.getCurrentPage());
        page.setSize(pageUserParam.getPageSize());
        Page<CommunityUser> userPage = this.page(page);
        List<CommunityUser> records = userPage.getRecords();
        return PageVo.<CommunityUser>builder()
                .items(records)
                .totalElement(userPage.getTotal())
                .totalPage(userPage.getPages())
                .build();
    }

    /**
     * 注册用户
     *
     * @param param 用户信息
     * @return 是否注册成功
     */
    @Override
    public Boolean registerUser(SaveUpdateUserParam param) {
        CommunityUser communityUser = new CommunityUser();
        BeanUtils.copyProperties(param, communityUser);
        //如果存在，则抛异常
        if (this.getById(communityUser.getUserId()) != null) {
            throw new RuntimeException("用户已存在");
        }
        return this.save(communityUser);
    }
}

