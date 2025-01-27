package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.GoodsDao;
import cn.xin.learn.community.entity.dto.goods.GoodsDto;
import cn.xin.learn.community.entity.params.goods.ExchangeGoodsParam;
import cn.xin.learn.community.entity.params.goods.PageGoodsParam;
import cn.xin.learn.community.entity.params.goods.SaveUpdateGoodsParam;
import cn.xin.learn.community.entity.po.Goods;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.feign.support.SmmsSupport;
import cn.xin.learn.community.service.GoodsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * 商品表;(Goods)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@Service("goodsService")
@RequiredArgsConstructor
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {
    private final SmmsSupport smmsSupport;

    /**
     * 保存或更新商品
     *
     * @param param 商品参数
     * @return 商品
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveOrUpdateGoods(SaveUpdateGoodsParam param) {
        Goods goods = BeanUtil.copyProperties(param, Goods.class);
        return saveOrUpdate(goods);
    }

    /**
     * 分页查询商品
     *
     * @param param 查询参数
     */
    @Override
    public PageVo<GoodsDto> pageGoods(PageGoodsParam param) {
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<Goods>()
                .eq(Objects.nonNull(param.getGoodsId()), Goods::getGoodsId, param.getGoodsId())
                .like(StringUtils.isNotEmpty(param.getGoodsName()), Goods::getGoodsName, param.getGoodsName())
                .le(Objects.nonNull(param.getGoodsIntegral()), Goods::getGoodsIntegral, param.getGoodsIntegral())
                .ge(Goods::getGoodsStock, param.getGoodsStock())
                .le(Objects.nonNull(param.getMaxGoodsPrice()), Goods::getGoodsPrice, param.getMaxGoodsPrice())
                .ge(Objects.nonNull(param.getMinGoodsPrice()), Goods::getGoodsPrice, param.getMinGoodsPrice());
        Page<Goods> page = Page.of(param.getCurrentPage(), param.getPageSize());
        page = this.page(page, wrapper);
        return PageVo.<GoodsDto>builder()
                .items(BeanUtil.copyToList(page.getRecords(), GoodsDto.class))
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .build();
    }

    /**
     * 兑换商品
     *
     * @param param
     */
    @Override
    public Boolean exchangeGoods(ExchangeGoodsParam param) {
        //todo
        return null;
    }

    /**
     * 删除商品
     *
     * @param goodsId
     */
    @Override
    public Boolean deleteGoods(Long goodsId) {
        CommunityAssert.notNull(goodsId, "商品Id不能为空");
        return removeById(goodsId);
    }


}

