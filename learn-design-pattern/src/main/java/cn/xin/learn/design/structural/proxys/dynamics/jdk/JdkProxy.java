package cn.xin.learn.design.structural.proxys.dynamics.jdk;

import cn.xin.learn.design.structural.proxys.biz.UserService;
import cn.xin.learn.design.structural.proxys.biz.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tiancx
 * @description: jdk动态代理
 * @date 2024年11月02日
 */
@Slf4j
public class JdkProxy {

    public static void main(String[] args) {
         UserService userService = new UserServiceImpl();
        // 获取类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        // 获取接口
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        UserService finalUserService = userService;
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info("✨哇偶：这就是动态代理，方法名：{}", method.getName());
                log.info("✨方法执行前");
                Object res = method.invoke(finalUserService, args);
                log.info("✨方法执行结果：{}", res);
                log.info("✨方法执行后");
                return res;
            }
        };

       userService = (UserService)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
       userService.talk();
    }
}
