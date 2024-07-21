package cn.xin.learn.design.creational.singleton.core;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author tiancx
 * @description: 懒汉式单例模式-线程不安全
 * @date 2024年07月20日
 */
@Slf4j
public class LazySingleton {
    private static LazySingleton lazySingleton;
    public LazySingleton(){
    }
    public static LazySingleton getInstance(){
        if(Objects.isNull(lazySingleton)){
            log.info("获取懒汉式单例模式-线程不安全");
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
