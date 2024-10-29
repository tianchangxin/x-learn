package cn.xin.learn.design.behavioral.chain.biz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tiancx
 * @description: 用户请求
 * @date 2024年10月27日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequset {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 请假天数
     */
    private Integer leaveDays;

    /**
     * 请假原因
     */
    private String leaveReason;

}
