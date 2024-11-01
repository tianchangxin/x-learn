package cn.xin.learn.design.behavioral.chain.core;

import cn.xin.learn.design.behavioral.chain.biz.UserRequset;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tiancx
 * @description: 责任链-直接领导处理
 * @date 2024年10月27日
 */
@Slf4j
public class DirectLeaderChainHandler implements UserChainHandlerFilter<UserRequset> {

    /**
     * 处理
     * @param userRequset 参数
     */
    @Override
    public void handler(UserRequset userRequset) {
        //假设通过
        if (userRequset.getLeaveDays() <= 3) {
            log.info("{}的请假天数小于等于3直接通过", userRequset.getUserName());
        }else {
            //通过了，但是天数大于5，需要部门领导审批
            log.info("{}的请假天数大于3，需要部门领导审批", userRequset.getUserName());
        }
    }

}
