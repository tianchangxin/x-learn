package cn.xin.learn.community.entity.params.integral;

import cn.xin.learn.community.entity.params.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 查询积分参数
 * @date 2025年01月27日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryIntegralParam extends BaseParam {
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
