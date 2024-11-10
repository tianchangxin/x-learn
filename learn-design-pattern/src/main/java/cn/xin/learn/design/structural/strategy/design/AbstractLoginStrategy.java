package cn.xin.learn.design.structural.strategy.design;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tiancx
 * @description: 登录策略
 * @date 2024年11月10日
 */
@Slf4j
public class AbstractLoginStrategy implements LoginStrategy<UserInfo> {
    @Override
    public boolean valid(UserInfo param) {
        return false;
    }

    public boolean doValidate(UserInfo param) {
        check(param);
        return valid(param);
    }

    /**
     * 校验,具体的校验逻辑由各自的子类实现
     */
    protected void check(UserInfo param) {
        log.info("校验用户信息-通用-父类");
        if (StringUtils.isEmpty(param.getUserId())) {
            throw new RuntimeException("用户id不能为空");
        }
    }

}
