package cn.xin.learn.design.structural.strategy.design;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author tiancx
 * @description: 手机号码验证
 * @date 2024年11月10日
 */
@Service("phoneValid")
@Slf4j
public class PhoneValidService extends AbstractLoginStrategy {
    @Override
    public boolean valid(UserInfo userInfo) {
        log.info("手机号码验证逻辑");
        return true;
    }

    @Override
    public void check(UserInfo userInfo) {
        super.check(userInfo);
        //校验
        if (StringUtils.isEmpty(userInfo.getPhoneNumber())) {
            throw new RuntimeException("手机号码不能为空");
        }
    }
}
