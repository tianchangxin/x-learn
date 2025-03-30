package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.IntegralDao;
import cn.xin.learn.community.entity.dto.integral.IntegralDto;
import cn.xin.learn.community.entity.params.integral.PageIntegralParam;
import cn.xin.learn.community.entity.params.integral.QueryIntegralParam;
import cn.xin.learn.community.entity.params.integral.SaveUpdateIntegralParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.po.Integral;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.enums.IntegralEnums;
import cn.xin.learn.community.enums.RolesEnum;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.helpers.UserHelper;
import cn.xin.learn.community.service.IntegralService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 积分;(Integral)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@Service("integralService")
public class IntegralServiceImpl extends ServiceImpl<IntegralDao, Integral> implements IntegralService {

    /**
     * 新增或保存积分
     *
     * @param param 新增或保存积分
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveUpdateIntegral(SaveUpdateIntegralParam param) {
        CommunityAssert.notNull(param.getBelongUserId(), "所属用户ID不能为空");
        //校验用户是否存在

        Integral integral = BeanUtil.copyProperties(param, Integral.class);
        return saveOrUpdate(integral);
    }

    /**
     * 分页查询积分
     *
     * @param param 分页查询积分
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public PageVo<IntegralDto> queryIntegralPage(PageIntegralParam param) {
        CommunityUser currentUser = UserHelper.getCurrentUser();
        if (Objects.equals(currentUser.getSuperAdmin(), RolesEnum.REGULAR_USER.getCode())) {
            //普通用户需要校验所属用户ID，超管不用
            CommunityAssert.notNull(param.getBelongUserId(), "所属用户ID不能为空");
        }
        //查询条件,【查询条件可能会有变动】
        LambdaQueryWrapper<Integral> wrapper = new LambdaQueryWrapper<Integral>()
                .eq(StringUtils.isNotEmpty(param.getIntegralOrigin()), Integral::getIntegralOrigin, param.getIntegralOrigin())
                .eq(Objects.nonNull(param.getBelongUserId()), Integral::getBelongUserId, param.getBelongUserId())
                .eq(Objects.nonNull(param.getIntegralType()), Integral::getIntegralType, param.getIntegralType());

        Page<Integral> page = Page.of(param.getCurrentPage(), param.getPageSize());
        page = this.page(page, wrapper);
        return PageVo.<IntegralDto>builder()
                .items(BeanUtil.copyToList(page.getRecords(), IntegralDto.class))
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .build();
    }

    /**
     * 查询用户积分列表
     *
     * @param param 查询用户积分列表
     */
    @Override
    public List<IntegralDto> queryUserIntegral(QueryIntegralParam param) {
        CommunityAssert.notNull(param.getBelongUserId(), "所属用户ID不能为空");
        //查询条件,【查询条件可能会有变动】
        LambdaQueryWrapper<Integral> wrapper = new LambdaQueryWrapper<Integral>()
                .eq(StringUtils.isNotEmpty(param.getIntegralOrigin()), Integral::getIntegralOrigin, param.getIntegralOrigin())
                .eq(Integral::getBelongUserId, param.getBelongUserId())
                .eq(Objects.nonNull(param.getIntegralType()), Integral::getIntegralType, param.getIntegralType());
        List<Integral> list = this.list(wrapper);
        return BeanUtil.copyToList(list, IntegralDto.class);
    }

    /**
     * 删除积分记录
     *
     * @param integralId 删除积分记录
     */
    @Override
    public Boolean deleteIntegral(Long integralId) {
        CommunityAssert.notNull(integralId, "积分ID不能为空");
        return this.removeById(integralId);
    }

    /**
     * 查询用户积分
     *
     * @param userId 用户ID
     */
    @Override
    public Double queryUserIntegral(Long userId) {
        CommunityAssert.notNull(userId, "用户ID不能为空");
        LambdaQueryWrapper<Integral> wrapper = new LambdaQueryWrapper<Integral>()
                .eq(Integral::getBelongUserId, userId);
        List<Integral> list = this.list(wrapper);
        if (CollectionUtils.isNotEmpty(list)) {
            //新增积分总和减去使用积分总和
            double addIntegral = list.stream().filter(x -> Objects.equals(x.getIntegralType(), IntegralEnums.ADD.getCode())).mapToDouble(Integral::getIntegralNum).sum();
            double useIntegral = list.stream().filter(x -> Objects.equals(x.getIntegralType(), IntegralEnums.USE.getCode())).mapToDouble(Integral::getIntegralNum).sum();
            return addIntegral - useIntegral;
        }
        return 0.0;
    }
}

