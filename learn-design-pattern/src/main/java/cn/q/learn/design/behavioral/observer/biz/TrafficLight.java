package cn.q.learn.design.behavioral.command.biz;

import cn.q.learn.design.behavioral.command.core.TrafficController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrafficLight extends TrafficController{
    @Override
    public void pass() {
        log.info("绿灯亮起。");
        this.trafficNotify(1);
    }

    @Override
    public void noPass() {
        log.info("红灯亮起。");
        this.trafficNotify(0);
    }
}
