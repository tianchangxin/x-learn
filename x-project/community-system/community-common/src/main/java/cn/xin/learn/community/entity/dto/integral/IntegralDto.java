package cn.xin.learn.community.entity.dto.integral;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xin
 * @description: 积分DTO
 * @date 2025年01月27日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegralDto {
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

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    //创建用户
    private String createUser;

    //修改用户
    private String updateUser;
}
