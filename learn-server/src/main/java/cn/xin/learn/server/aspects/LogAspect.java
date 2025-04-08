package cn.xin.learn.server.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author xin
 * @description: 日志切面
 * @date 2025年04月05日
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Around("execution(* cn.xin.learn.server.service..*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("日志切面：进入around");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("日志切面：{}-{}耗时：{}ms", className, methodName, end - start);
        return proceed;
    }

    @Before("execution(* cn.xin.learn.server.service..*(..))")
    public void before() {
        log.info("日志切面：before");
    }

    @After("execution(* cn.xin.learn.server.service..*(..))")
    public void after() {
        log.info("日志切面：after");
    }

}
