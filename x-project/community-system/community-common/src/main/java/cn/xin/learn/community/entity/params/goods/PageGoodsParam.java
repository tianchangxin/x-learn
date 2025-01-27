package cn.xin.learn.community.entity.params.goods;

import cn.xin.learn.community.entity.params.PageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 分页查询商品参数
 * @date 2025年01月27日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageGoodsParam extends PageParam {
    //商品Id
    private Long goodsId;
    //商品名
    private String goodsName;
    //商品所需积分
    private Double goodsIntegral;
    //商品库存
    private Integer goodsStock = 1;
    //商品单价-最小
    private Double minGoodsPrice;
    //商品单价-最大
    private Double maxGoodsPrice;
}
