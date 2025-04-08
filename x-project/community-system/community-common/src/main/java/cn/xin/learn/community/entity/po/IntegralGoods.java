package cn.xin.learn.community.entity.po;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;

/**
 * (IntegralGoods)表实体类
 *
 * @author makejava
 * @since 2025-04-08 11:20:29
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntegralGoods{

    private Integer id;
    //用户ID
    private Integer userId;
    //是否核销（0：已核销，1：未核销）
    private Integer verification;
    //商品ID
    private Long goodId;

}

