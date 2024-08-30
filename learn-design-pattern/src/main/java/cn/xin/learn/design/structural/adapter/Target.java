package cn.xin.learn.design.structural.adapter;

/**
 * @author tiancx
 * @description: 适配器模式-目标接口
 * @date 2024年08月30日
 * @param <T> 被适配的类型
 */
public interface Target<T> {

    //获取温度
    Double target(T adaptee);
}
