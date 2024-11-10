package cn.xin.learn.design.structural.strategy.design;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author tiancx
 * @description: 邮件验证
 * @date 2024年11月10日
 */
@Service("mailValid")
@Slf4j
public class MailValidService extends AbstractLoginStrategy {
    @Override
    public boolean valid(UserInfo userInfo) {
        log.info("邮箱验证逻辑");
        return true;
    }

    @Override
    protected void check(UserInfo userInfo) {
        super.check(userInfo);
        //校验
        String email = userInfo.getEmail();
        if (StringUtils.isEmpty(email)) {
            throw new RuntimeException("邮箱不能为空");
        }
    }
}
