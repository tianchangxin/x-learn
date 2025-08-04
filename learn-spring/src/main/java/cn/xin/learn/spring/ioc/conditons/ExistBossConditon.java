package cn.xin.learn.spring.ioc.conditons;

import cn.xin.learn.spring.ioc.entity.Boss;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author tiancx
 * @description: 判断boss是否存在
 * @date 2024年12月01日
 */
public class ExistBossConditon implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getBeanFactory().containsBeanDefinition(Boss.class.getName());

    }
}
