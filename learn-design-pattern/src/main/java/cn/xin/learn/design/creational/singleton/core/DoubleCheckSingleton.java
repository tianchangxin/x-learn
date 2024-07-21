package cn.xin.learn.design.creational.singleton.core;

import java.util.Objects;

/**
 * @author tiancx
 * @description: 懒汉式单例模式-线程安全-双重检查
 * @date 2024年07月20日
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton doubleCheckSingleton;
    public DoubleCheckSingleton(){
    }
    public static DoubleCheckSingleton getInstance(){
        if(Objects.isNull(doubleCheckSingleton)){
            synchronized (DoubleCheckSingleton.class){
                if(Objects.isNull(doubleCheckSingleton)){
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }
}
