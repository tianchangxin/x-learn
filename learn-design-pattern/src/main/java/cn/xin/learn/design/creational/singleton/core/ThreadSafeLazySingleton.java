package cn.xin.learn.design.creational.singleton.core;

import java.util.Objects;

/**
 * @author tiancx
 * @description: 懒汉式单例模式-线程安全-效率低
 * @date 2024年07月20日
 */
public class ThreadSafeLazySingleton {
    private static ThreadSafeLazySingleton threadSafeLazySingleton;
    public ThreadSafeLazySingleton(){
    }
    public static synchronized ThreadSafeLazySingleton getInstance(){
        if(Objects.isNull(threadSafeLazySingleton)){
            threadSafeLazySingleton = new ThreadSafeLazySingleton();
        }
        return threadSafeLazySingleton;
    }
}
