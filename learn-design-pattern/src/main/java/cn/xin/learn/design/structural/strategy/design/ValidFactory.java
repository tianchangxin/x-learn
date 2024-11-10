package cn.xin.learn.design.structural.strategy.design;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tiancx
 * @description: 验证工厂
 * @date 2024年11月10日
 */
@Slf4j
@Component
public class ValidFactory {
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 根据验证类型获取对应验证实现类
     */
//    public static LoginStrategy<UserInfo> getInstance(String validType) {
//        if (StringUtils.equals(validType, "phone")) {
//            //这里应该用单例模式，这里为了方便就直接new了
//            return new PhoneValidService();
//        }
//        if (StringUtils.equals(validType, "email")) {
//            return new MailValidService();
//        }
//        return null;
//    }
    public AbstractLoginStrategy getInstance(String validType) {
        AbstractLoginStrategy bean = applicationContext.getBean(validType + "Valid", AbstractLoginStrategy.class);
        log.info("bean:{}", bean);
        return bean;
    }


}
