package cn.xin.learn.design.structural.strategy.design;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年11月10日
 */
@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final ValidFactory validFactory;

    /**
     * 登录
     */
    public String valid(UserInfo param) {
        //校验
        String validType = param.getValidType();
        AbstractLoginStrategy strategy = validFactory.getInstance(validType);
        if (Objects.nonNull(strategy)) {
            boolean valid = strategy.doValidate(param);
            return valid ? "login success" : "login fail";
        }
        return "login fail";
    }

}
