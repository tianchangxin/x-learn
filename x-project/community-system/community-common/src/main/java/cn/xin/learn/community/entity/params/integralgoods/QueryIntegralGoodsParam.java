package cn.xin.learn.community.entity.params.integralgoods;

import cn.xin.learn.community.entity.params.PageParam;
import cn.xin.learn.community.entity.po.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: QueryIntegralGoodsParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.integralgoods
 * @Date 2025/4/8 11:29
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryIntegralGoodsParam extends PageParam {
    private Integer id;
    //用户ID
    private Integer userId;
    //商品id
    private Integer goodId;
    //是否核销（0：已核销，1：未核销）
    private Integer verification;
}
