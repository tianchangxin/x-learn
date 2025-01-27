package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.goods.GoodsDto;
import cn.xin.learn.community.entity.params.goods.ExchangeGoodsParam;
import cn.xin.learn.community.entity.params.goods.PageGoodsParam;
import cn.xin.learn.community.entity.params.goods.SaveUpdateGoodsParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 商品表;(Goods)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@RestController
@RequestMapping("goods")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    /**
     * 保存或更新商品
     *
     * @param param 商品参数
     * @return 商品
     */
    @PostMapping("saveOrUpdateGoods")
    public Boolean saveOrUpdateGoods(@Validated @RequestBody SaveUpdateGoodsParam param) {
        return goodsService.saveOrUpdateGoods(param);
    }

    /**
     * 分页查询商品
     */
    @PostMapping("pageGoods")
    public PageVo<GoodsDto> pageGoods(@Validated @RequestBody PageGoodsParam param) {
        return goodsService.pageGoods(param);
    }

    /**
     * 删除商品
     */
    @PostMapping("deleteGoods")
    public Boolean deleteGoods(Long goodsId) {
        return goodsService.deleteGoods(goodsId);
    }

    /**
     * 兑换商品
     */
    @PostMapping("exchangeGoods")
    public Boolean exchangeGoods(@Validated @RequestBody ExchangeGoodsParam param) {
        return goodsService.exchangeGoods(param);
    }

}

