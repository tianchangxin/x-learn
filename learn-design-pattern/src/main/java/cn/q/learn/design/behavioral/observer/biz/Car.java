package cn.q.learn.design.behavioral.command.biz;

import cn.q.learn.design.behavioral.command.core.TrafficJoiner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Car implements TrafficJoiner {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        log.info(name+"可以走了");
    }

    @Override
    public void stop() {
        log.info(name+"不可以走了");
    }
}
