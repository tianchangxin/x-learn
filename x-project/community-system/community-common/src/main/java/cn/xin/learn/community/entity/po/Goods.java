package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 商品表;(Goods)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@SuppressWarnings("serial")
@Data
public class Goods extends BasePo {
    //商品Id
    @TableId(type = IdType.AUTO)
    private Long goodsId;
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

