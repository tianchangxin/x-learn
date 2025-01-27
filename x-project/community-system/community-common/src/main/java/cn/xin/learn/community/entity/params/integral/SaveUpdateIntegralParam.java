package cn.xin.learn.community.entity.params.integral;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 保存更新积分参数
 * @date 2025年01月27日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUpdateIntegralParam {
    //积分ID(新增时不传，修改时传)
    private Long integralId;
    //积分来源
    private String integralOrigin;
    //积分数量
    private Double integralNum;
    //归属用户
    private String belongUser;
    //归属用户Id
    private Integer belongUserId;
    //积分类型（0-使用、1-新增）
    private Integer integralType;
}
