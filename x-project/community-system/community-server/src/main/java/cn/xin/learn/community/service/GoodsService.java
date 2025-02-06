package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.goods.GoodsDto;
import cn.xin.learn.community.entity.params.goods.ExchangeGoodsParam;
import cn.xin.learn.community.entity.params.goods.PageGoodsParam;
import cn.xin.learn.community.entity.params.goods.SaveUpdateGoodsParam;
import cn.xin.learn.community.entity.po.Goods;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品表;(Goods)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 保存或更新商品
     *
     * @param param 商品参数
     * @return 商品
     */
    Boolean saveOrUpdateGoods(SaveUpdateGoodsParam param);

    /**
     * 分页查询商品
     *
     * @param param 查询参数
     */
    PageVo<GoodsDto> pageGoods(PageGoodsParam param);

    /**
     * 删除商品
     */
    Boolean deleteGoods(Long goodsId);

    /**
     * 兑换商品
     */
    Boolean exchangeGoods(ExchangeGoodsParam param);


}

