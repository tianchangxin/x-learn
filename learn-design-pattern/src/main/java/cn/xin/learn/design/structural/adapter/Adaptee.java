package cn.xin.learn.design.structural.adapter;

/**
 * @author tiancx
 * @description: 适配器模式-被适配者,可以有多个，比如各种不同的MQ消息
 * @date 2024年08月30日
 */
public class Adaptee {

    public Double getTemperature() {
        return 31.0;
    }
}
