package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.intergralgoods.IntegralGoodsDto;
import cn.xin.learn.community.entity.params.integralgoods.QueryIntegralGoodsParam;
import cn.xin.learn.community.entity.params.integralgoods.SaveOrUpdateIntegralGoodsParam;
import cn.xin.learn.community.entity.po.IntegralGoods;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (IntegralGoods)表服务接口
 *
 * @author makejava
 * @since 2025-04-08 11:20:29
 */
public interface IntegralGoodsService extends IService<IntegralGoods> {

    PageVo<IntegralGoodsDto> queryIntegralGoodsPage(QueryIntegralGoodsParam param);

    Boolean saveIntegralGoods(SaveOrUpdateIntegralGoodsParam param);
}

