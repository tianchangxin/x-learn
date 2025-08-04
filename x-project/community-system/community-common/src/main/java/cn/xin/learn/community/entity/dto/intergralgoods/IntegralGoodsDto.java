package cn.xin.learn.community.entity.dto.intergralgoods;

import cn.xin.learn.community.entity.po.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: IntegralGoodsDto
 * @Author yinan
 * @Package cn.xin.learn.community.entity.dto.intergralgoods
 * @Date 2025/4/8 11:31
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegralGoodsDto {
    private Integer id;
    //用户ID
    private Integer userId;
    //商品信息
    private Goods goods;
    //是否核销（0：已核销，1：未核销）
    private Integer verification;
}
