package cn.xin.learn.design.structural.strategy.design;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tiancx
 * @description: 用户信息
 * @date 2024年11月10日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String name;
    private String userId;
    private String phoneNumber;
    private String email;
    /**
     * mail: 邮箱，phone: 手机号，wechat: 微信
     */
    private String validType;
}
