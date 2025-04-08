package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.intergralgoods.IntegralGoodsDto;
import cn.xin.learn.community.entity.params.integralgoods.QueryIntegralGoodsParam;
import cn.xin.learn.community.entity.params.integralgoods.SaveOrUpdateIntegralGoodsParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.IntegralGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 用户物品对应积分兑换
 * (IntegralGoods)表控制层
 *
 * @author makejava
 * @since 2025-04-08 11:20:28
 */
@RestController
@RequestMapping("integralGoods")
public class IntegralGoodsController{
    /**
     * 服务对象
     */
    @Resource
    private IntegralGoodsService integralGoodsService;


    /**
     * 查询当前用户兑换物品列表（包括已核销、未核销）
     * @param param
     * @return
     */
    @PostMapping("queryIntegralGoodsPage")
    public PageVo<IntegralGoodsDto> queryIntegralGoodsPage(@RequestBody QueryIntegralGoodsParam param) {
        return integralGoodsService.queryIntegralGoodsPage(param);
    }


    /**
     * 新增或修改当前用户兑换物品记录
     * @param param
     * @return
     */
    @PostMapping("saveIntegralGoods")
    public Boolean saveIntegralGoods(@RequestBody SaveOrUpdateIntegralGoodsParam param) {
        return integralGoodsService.saveIntegralGoods(param);
    }

}

