package cn.xin.learn.design.structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: 适配器模式-适配器
 * @date 2024年08月30日
 */
@Slf4j
public class Adapter implements Target<Adaptee> {

    @Override
    public Double target(Adaptee adaptee) {
        Double temperature = adaptee.getTemperature();
        log.info("适配器模式-目标接口-获取温度：{}", temperature);
        return (temperature - 32) / 1.8;
    }
}
