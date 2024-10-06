package com.ztc.learn.mybatis.plugins;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.List;

/**
 * @author tiancx
 * @description: 自定义插件-统计列表数量
 * @date 2024年10月05日
 */
@Slf4j
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class CountPlug implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object proceed = invocation.proceed();
        log.info("CountPlug拦截到了方法执行,统计数量={}",((List<?>)proceed).size());
        return proceed;
    }
}
