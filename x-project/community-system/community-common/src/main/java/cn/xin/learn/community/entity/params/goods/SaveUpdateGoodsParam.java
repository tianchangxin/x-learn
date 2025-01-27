package cn.xin.learn.community.entity.params.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author xin
 * @description: 保存更新商品参数
 * @date 2025年01月27日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUpdateGoodsParam {
    //商品Id(新增时不传，修改时传)
    private Long goodsId;
    //商品名
    @NotEmpty(message = "商品名不能为空")
    private String goodsName;
    //商品图片
    private String goodsPic;
    //商品所需积分
    @NotNull(message = "商品所需积分不能为空")
    private Double goodsIntegral;
    //商品库存
    @NotNull(message = "商品库存不能为空")
    private Integer goodsStock;
    //商品单价
    @NotNull(message = "商品单价不能为空")
    private Double goodsPrice;

}
