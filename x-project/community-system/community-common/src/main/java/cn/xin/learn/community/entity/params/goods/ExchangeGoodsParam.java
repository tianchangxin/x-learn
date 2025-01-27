package cn.xin.learn.community.entity.params.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author xin
 * @description: 兑换商品参数
 * @date 2025年01月27日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeGoodsParam {
    //商品Id
    @NotEmpty(message = "商品ID不能为空")
    private Long goodsId;

}
