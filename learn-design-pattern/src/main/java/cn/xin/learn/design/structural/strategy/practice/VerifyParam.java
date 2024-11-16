package cn.xin.learn.design.structural.strategy.practice;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tiancx
 * @description: 参数
 * @date 2024年11月16日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyParam {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 密保问题和答案 - 这里简单处理
     */
    private JSONObject questionAndAnswer;

    /**
     * 验证类型
     */
    private String verifyType;
}
