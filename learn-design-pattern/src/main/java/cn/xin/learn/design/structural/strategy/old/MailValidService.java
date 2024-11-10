package cn.xin.learn.design.structural.strategy.old;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tiancx
 * @description: 邮件验证
 * @date 2024年11月10日
 */
@Service("oldMail")
@Slf4j
public class MailValidService {
    public boolean valid(UserInfo userInfo) {
        log.info("邮箱验证逻辑");
        return true;
    }
}
