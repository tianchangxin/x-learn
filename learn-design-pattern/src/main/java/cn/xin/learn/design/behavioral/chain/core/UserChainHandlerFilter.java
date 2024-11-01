package cn.xin.learn.design.behavioral.chain.core;

import cn.xin.learn.design.behavioral.chain.biz.UserRequset;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年10月27日
 */
public interface UserChainHandlerFilter<UserRequset> extends ChainHandler<UserRequset> {
    @Override
    default String mark() {
        //这里可以用枚举-待优化
        return "userLeave";
    }

}
