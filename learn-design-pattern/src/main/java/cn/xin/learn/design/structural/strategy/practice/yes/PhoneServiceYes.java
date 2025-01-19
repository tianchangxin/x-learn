package cn.xin.learn.design.structural.strategy.practice.yes;

import cn.xin.learn.design.structural.strategy.practice.VerifyParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author tiancx
 * @description: 手机验证码服务
 * @date 2024年11月16日
 */
@Service(value = "phoneStrategy")
@Slf4j
public class PhoneServiceYes implements VerifyStrategy<VerifyParam> {

    @Override
    public String verify(VerifyParam param) {
        //校验
        Assert.isTrue(StringUtils.isNotEmpty(param.getUserId()), "用户ID不能为空");
        Assert.isTrue(StringUtils.isNotEmpty(param.getPhoneNumber()), "手机号不能为空");
        // 业务逻辑
        log.info("进行手机号验证码验证逻辑~");
        // 这里简单处理，直接返回
        return "手机验证码验证成功";
    }

}
