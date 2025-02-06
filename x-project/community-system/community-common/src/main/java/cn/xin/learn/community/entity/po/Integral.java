package cn.xin.learn.community.entity.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 积分;(Integral)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@Data
public class Integral extends BasePo {
    //积分ID
    @TableId(type = IdType.AUTO)
    private Long integralId;
    //积分来源
    private String integralOrigin;
    //积分数量
    private Double integralNum;
    //归属用户
    private String belongUser;
    //归属用户Id
    private Long belongUserId;
    //积分类型（0-使用、1-新增）
    private Integer integralType;

}

