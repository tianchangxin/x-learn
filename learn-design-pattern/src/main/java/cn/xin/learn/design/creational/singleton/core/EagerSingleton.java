package cn.xin.learn.design.creational.singleton.core;

/**
 * @author tiancx
 * @description: 饿汉式单例模式
 * @date 2024年07月20日
 */
public class EagerSingleton {
    private static final EagerSingleton EAGER_SINGLETON = new EagerSingleton();
    private EagerSingleton(){
    }
    public static EagerSingleton getInstance(){
        return EAGER_SINGLETON;
    }
}
