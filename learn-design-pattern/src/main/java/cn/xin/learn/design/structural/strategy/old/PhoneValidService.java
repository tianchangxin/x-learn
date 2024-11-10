package cn.xin.learn.design.structural.strategy.old;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tiancx
 * @description: 手机号码验证
 * @date 2024年11月10日
 */
@Service("oldPhone")
@Slf4j
public class PhoneValidService {
    public boolean valid(UserInfo userInfo) {
        log.info("手机号码验证逻辑");
        return true;
    }
}
