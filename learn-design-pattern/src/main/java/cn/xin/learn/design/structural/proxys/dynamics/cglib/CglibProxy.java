package cn.xin.learn.design.structural.proxys.dynamics.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tiancx
 * @description: cglib动态代理
 * @date 2024年11月02日
 */
@Slf4j
public class CglibProxy {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Enhancer enhancer = new Enhancer();
        //获取并设置classLoader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        enhancer.setClassLoader(classLoader);
        //设置父类
        enhancer.setSuperclass(UserService.class);
        //设置回调方法
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                log.info("cglib动态代理");
                log.info("✨方法执行前");
                Object res = methodProxy.invokeSuper(o, objects);
                log.info("✨方法执行结果：{}",res);
                log.info("✨方法执行后");
                return res;
            }
        });
        //创建代理对象
        userService = (UserService) enhancer.create();
        userService.talk();
    }
}
