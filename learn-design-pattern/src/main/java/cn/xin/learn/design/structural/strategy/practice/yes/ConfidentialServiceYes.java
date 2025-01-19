package cn.xin.learn.design.structural.strategy.practice.yes;

import cn.xin.learn.design.structural.strategy.practice.VerifyParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author tiancx
 * @description: 密保问题服务
 * @date 2024年11月16日
 */
@Service("confidentialStrategy")
@Slf4j
public class ConfidentialServiceYes implements VerifyStrategy<VerifyParam> {

    @Override
    public String verify(VerifyParam param) {
        //校验
        Assert.isTrue(StringUtils.isNotEmpty(param.getUserId()), "用户ID不能为空");
        Assert.isTrue(MapUtils.isNotEmpty(param.getQuestionAndAnswer()), "手机号不能为空");
        // 业务逻辑
        log.info("进行密保问题验证逻辑~");
        // 这里简单处理，直接返回
        return "密保问题验证成功";
    }
}
