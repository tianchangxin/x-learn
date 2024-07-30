package cn.q.learn.design.behavioral.command.biz;

import cn.q.learn.design.behavioral.command.core.TrafficController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PoliceMan extends TrafficController {
    @Override
    public void pass() {
        log.info("行人可以走了。");
        this.trafficNotify(1);
    }

    @Override
    public void noPass() {
        log.info("行人不可以走了。");
        this.trafficNotify(0);
    }
}
