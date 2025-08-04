package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.xin.learn.community.checks.user.UserCheck;
import cn.xin.learn.community.dao.CommunityUserDao;
import cn.xin.learn.community.entity.dto.user.CommunityUserDto;
import cn.xin.learn.community.entity.params.user.LoginUserParam;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 社区用户表;(CommunityUser)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:22
 */
@Service("communityUserService")
public class CommunityUserServiceImpl extends ServiceImpl<CommunityUserDao, CommunityUser> implements CommunityUserService {

    @Autowired
    private CommunityUserDao communityUserDao;

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
        communityUser.setUserId(param.getUserId());
        if(Objects.nonNull(param.getUserId())){
            return communityUserDao.updateById(communityUser)>0;
        }
        else{
           return communityUserDao.insert(communityUser)>0;
        }
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

    /**
     * 登录
     *
     * @param param 登录参数
     * @return 是否登录成功
     */
    @Override
    public CommunityUserDto login(LoginUserParam param) {
        //校验参数
        UserCheck.checkLoginUserParam(param);
        CommunityUser user = BeanUtil.copyProperties(param, CommunityUser.class);
        LambdaQueryWrapper<CommunityUser> wrapper = new LambdaQueryWrapper<CommunityUser>()
                .and(w -> {
                    w.eq(StringUtils.isNotEmpty(param.getUserName()), CommunityUser::getUserName, user.getUserName());
                    w.or();
                    w.eq(StringUtils.isNotEmpty(param.getEmail()), CommunityUser::getEmail, user.getUserName());
                })
                .eq(CommunityUser::getPwd, user.getPwd());
        CommunityUser communityUser = this.getOne(wrapper);
        if (Objects.isNull(communityUser)) {
            CommunityAssert.fail("用户名或密码错误");
        }
        return BeanUtil.copyProperties(communityUser, CommunityUserDto.class);
    }


    /**
     * 不分页根据部门id获取用户信息
     * @param deptId 社区id
     * @return 用户信息
     */
    @Override
    public List<CommunityUserDto> getUserinfoByDeptId(Integer deptId) {
        LambdaQueryWrapper<CommunityUser> wrapper = new LambdaQueryWrapper<CommunityUser>()
                .eq(CommunityUser::getDeptId, deptId);
        List<CommunityUser> list = this.list(wrapper);
        return list.stream()
                .map(x -> Convert.convert(CommunityUserDto.class, x))
                .collect(Collectors.toList());
    }
}

