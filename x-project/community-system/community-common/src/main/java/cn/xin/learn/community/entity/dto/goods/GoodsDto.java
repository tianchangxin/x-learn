package cn.xin.learn.community.entity.dto.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 商品DTO
 * @date 2025年01月27日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDto {
    //商品Id
    private Integer goodsId;
    //商品名
    private String goodsName;
    //商品图片
    private String goodsPic;
    //商品所需积分
    private Double goodsIntegral;
    //商品库存
    private Integer goodsStock;
    //商品单价
    private Double goodsPrice;
}
