package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.IntegralGoodsDao;
import cn.xin.learn.community.entity.dto.intergralgoods.IntegralGoodsDto;
import cn.xin.learn.community.entity.params.integralgoods.QueryIntegralGoodsParam;
import cn.xin.learn.community.entity.params.integralgoods.SaveOrUpdateIntegralGoodsParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.po.Goods;
import cn.xin.learn.community.entity.po.IntegralGoods;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.helpers.UserHelper;
import cn.xin.learn.community.service.GoodsService;
import cn.xin.learn.community.service.IntegralGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * (IntegralGoods)表服务实现类
 *
 * @author makejava
 * @since 2025-04-08 11:20:30
 */
@Service
public class IntegralGoodsServiceImpl extends ServiceImpl<IntegralGoodsDao, IntegralGoods> implements IntegralGoodsService {

    @Autowired
    private GoodsService goodsService;


    @Override
    public PageVo<IntegralGoodsDto> queryIntegralGoodsPage(QueryIntegralGoodsParam param) {
        // 获取当前登录用户
        CommunityUser currentUser = UserHelper.getCurrentUser();
        Page<IntegralGoods> page = Page.of(param.getCurrentPage(), param.getPageSize());
        LambdaQueryWrapper<IntegralGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(IntegralGoods::getUserId, currentUser.getUserId())
                .eq(Objects.nonNull(param.getVerification()), IntegralGoods::getVerification, param.getVerification());

        // 查询用户兑换的商品信息，并进行分页
        Page<IntegralGoods> integralGoodsPage = this.page(page, wrapper);
        List<IntegralGoods> integralGoodsList = integralGoodsPage.getRecords();

        // 查询所有商品信息
        List<Goods> goodsList = goodsService.list(new LambdaQueryWrapper<>(Goods.class).eq(Goods::getIsDelete, 0));
        Map<Long, Goods> goodsMap = goodsList.stream()
                .collect(Collectors.toMap(Goods::getGoodsId, goods -> goods));

        // 将 IntegralGoods 转换为 IntegralGoodsDto
        List<IntegralGoodsDto> integralGoodsDtos = integralGoodsList.stream()
                .map(integralGoods -> {
                    IntegralGoodsDto integralGoodsDto = new IntegralGoodsDto();
                    BeanUtil.copyProperties(integralGoods, integralGoodsDto);
                    integralGoodsDto.setGoods(goodsMap.get(integralGoods.getGoodId()));
                    return integralGoodsDto;
                }).collect(Collectors.toList());

        // 获取分页参数
        int currentPage = param.getCurrentPage();
        int pageSize = param.getPageSize();

        // 计算分页结果
        int start = (currentPage - 1) * pageSize;
        int end = Math.min(start + pageSize, integralGoodsDtos.size());
        List<IntegralGoodsDto> pagedIntegralGoodsDtos = integralGoodsDtos.subList(start, end);

        // 构建分页结果
        return PageVo.<IntegralGoodsDto>builder()
                .totalPage(integralGoodsPage.getPages())
                .totalElement(integralGoodsPage.getTotal())
                .items(BeanUtil.copyToList(pagedIntegralGoodsDtos, IntegralGoodsDto.class))
                .build();
    }

    @Override
    public Boolean saveIntegralGoods(SaveOrUpdateIntegralGoodsParam param){
        CommunityUser currentUser = UserHelper.getCurrentUser();
        IntegralGoods integralGoods = IntegralGoods.builder()
                .userId(Math.toIntExact(currentUser.getUserId()))
                .verification(param.getVerification())
                .goodId(param.getGoodId())
                .build();
        return this.saveOrUpdate(integralGoods);
    }


}

