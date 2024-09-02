package cn.xin.learn.server.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年09月02日
 */
@Aspect
@Component
@Slf4j
public class CostTimeAspect {
    @Around("@annotation(cn.xin.learn.server.annotations.CostTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("耗时统计：{}-{}耗时：{}ms",className,methodName,end-start);
        return proceed;
    }



}
