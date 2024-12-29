package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.checks.user.UserCheck;
import cn.xin.learn.community.dao.CommunityUserDao;
import cn.xin.learn.community.entity.params.user.PageUserParam;
import cn.xin.learn.community.entity.params.user.SaveUpdateUserParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.helpers.UserHelper;
import cn.xin.learn.community.service.CommunityUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
     * @param param 分页参数
     * @return 用户列表
     */
    @Override
    public PageVo<CommunityUser> queryUserList(PageUserParam param) {
        //分页查询
        LambdaQueryWrapper<CommunityUser> wrapper = new LambdaQueryWrapper<CommunityUser>()
                .eq(Objects.nonNull(param.getUserId()), CommunityUser::getUserId, param.getUserId())
                .like(StringUtils.isNotEmpty(param.getUserName()), CommunityUser::getUserName, param.getUserName())
                .eq(Objects.nonNull(param.getUserSex()), CommunityUser::getUserSex, param.getUserSex())
                .eq(StringUtils.isNotEmpty(param.getEmail()), CommunityUser::getEmail, param.getEmail())
                .eq(Objects.nonNull(param.getRole()), CommunityUser::getRole, param.getRole())
                .eq(Objects.nonNull(param.getDeptId()), CommunityUser::getDeptId, param.getDeptId())
                .eq(Objects.nonNull(param.getSuperAdmin()), CommunityUser::getSuperAdmin, param.getSuperAdmin())
                .eq(Objects.nonNull(param.getStatus()), CommunityUser::getStatus, param.getStatus());
        Page<CommunityUser> page = Page.of(param.getCurrentPage(), param.getPageSize());
        page = this.page(page, wrapper);
        return PageVo.<CommunityUser>builder()
                .items(page.getRecords())
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
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
        //校验参数
        UserCheck.checkRegisterUserParam(param);
        //如果存在，则抛异常
        LambdaQueryWrapper<CommunityUser> wrapper = new LambdaQueryWrapper<CommunityUser>()
                .eq(CommunityUser::getUserName, param.getUserName());
        if (Objects.nonNull(this.getOne(wrapper))) {
            CommunityAssert.fail("用户已存在");
        }
        //复制属性
        BeanUtils.copyProperties(param, communityUser);
        //设置到当前用户中
        UserHelper.setCurrentUser(communityUser);
        //保存用户
        return save(communityUser);
    }

    /**
     * 删除用户
     *
     * @param userIds 用户ID集合
     * @return 是否删除成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteUser(List<Long> userIds) {
        CommunityAssert.notEmpty(userIds, "用户ID集合不能为空");
        return this.removeByIds(userIds);
    }
}

