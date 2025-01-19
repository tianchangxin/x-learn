package cn.xin.learn.design.structural.strategy.practice;

import cn.xin.learn.design.structural.strategy.practice.no.ConfidentialService;
import cn.xin.learn.design.structural.strategy.practice.no.PhoneService;
import cn.xin.learn.design.structural.strategy.practice.yes.StrategyFactory;
import cn.xin.learn.design.structural.strategy.practice.yes.VerifyStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author tiancx
 * @description: 验证service
 * @date 2024年11月16日
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class VerifyService {
    private final PhoneService phoneService;
    private final ConfidentialService confidentialService;
    private final StrategyFactory strategyFactory;

    public String verify(VerifyParam param) {
        String verifyType = param.getVerifyType();
        if (StringUtils.equals(VerifyEnums.PHONE.getType(), verifyType)) {
            return phoneService.verify(param);
        }
        if (StringUtils.equals(VerifyEnums.CONFIDENTIAL.getType(), verifyType)) {
            return confidentialService.verify(param);
        }
        return "验证失败,请重试~";
    }

    public String verifyYes(VerifyParam param) {
        String verifyType = param.getVerifyType();
        VerifyStrategy<VerifyParam> strategy = strategyFactory.getStrategy(verifyType);
        String verify = strategy.verify(param);
        if (StringUtils.isNotEmpty(verify)) {
            return verify;
        }
        return "验证失败,请重试~";
    }
}
