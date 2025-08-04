package cn.xin.learn.community.entity.params.integralgoods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: SaveOrUpdateIntegralGoodsParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.integralgoods
 * @Date 2025/4/8 14:32
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrUpdateIntegralGoodsParam {
    private Integer id;
    //商品id
    private Long goodId;
    //是否核销（0：已核销，1：未核销）
    private Integer verification;
}
