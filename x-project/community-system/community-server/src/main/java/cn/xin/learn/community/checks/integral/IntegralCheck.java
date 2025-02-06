package cn.xin.learn.community.checks.integral;

import cn.xin.learn.community.entity.po.Goods;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import lombok.Data;

/**
 * @author xin
 * @description: 积分&商品兑换校验
 * @date 2025年02月03日
 */
@Data
public class IntegralCheck {

    /**
     * 校验积分是否足够
     *
     * @param integral      用户积分
     * @param goodsIntegral 商品所需积分
     * @return boolean
     */
    public static boolean checkIntegral(Double integral, Double goodsIntegral) {
        return integral >= goodsIntegral;
    }

    /**
     * 校验商品库存是否足够
     *
     * @param goodsStock 商品库存
     * @return boolean
     */
    public static boolean checkGoodsStock(Integer goodsStock) {
        return goodsStock > 0;
    }

    /**
     * 校验商品能否兑换
     *
     * @param integral 用户积分
     * @param goods    商品信息
     */
    public static void checkGoodsCanExchange(Double integral, Goods goods) {
        boolean checkIntegral = checkIntegral(integral, goods.getGoodsIntegral());
        CommunityAssert.isTrue(checkIntegral, "积分不足");
        boolean checkGoodsStock = checkGoodsStock(goods.getGoodsStock());
        CommunityAssert.isTrue(checkGoodsStock, "商品库存不足");
    }
}
