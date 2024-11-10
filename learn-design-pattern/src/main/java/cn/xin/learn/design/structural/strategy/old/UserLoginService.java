package cn.xin.learn.design.structural.strategy.old;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年11月10日
 */
@Service("oldUser")
@RequiredArgsConstructor
public class UserLoginService {
    private final MailValidService mailValidService;
    private final PhoneValidService phoneValidService;

    /**
     * 登录
     */
    public String valid(UserInfo param) {
        //校验
        String validType = param.getValidType();
        if (StringUtils.equals(validType, "phone")) {
            //  手机号验证逻辑
            boolean valid = phoneValidService.valid(param);
            return valid ? "login success" : "login fail";
        }
        if (StringUtils.equals(validType, "email")) {
            //  邮箱验证逻辑
            boolean valid = mailValidService.valid(param);
            return valid ? "login success" : "login fail";
        }
        //如果在家其的验证方式，会在写很多的if
        return "login fail";
    }
}
