package cn.xin.learn.design.behavioral.chain.core;

import cn.xin.learn.design.behavioral.chain.biz.UserRequset;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 责任链模式-部门领导
 * @date 2024年10月28日
 */
@Slf4j
public class DepartmentLeaderChainHandler implements UserChainHandlerFilter<UserRequset> {
    /**
     * 处理
     * @param userRequset 参数
     */
    @Override
    public void handler(UserRequset userRequset) {
        Integer leaveDays = userRequset.getLeaveDays();
        if(leaveDays > 3 && leaveDays <=7 ) {
            log.info("{}的请假，在部门领导这边通过", userRequset.getUserName());
        }
        if(leaveDays > 7) {
            log.info("{}的请假，超过7天，需要HR审批", userRequset.getUserName());
        }

    }
}
