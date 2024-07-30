package cn.q.learn.design.behavioral.command.core;

import java.util.ArrayList;
import java.util.List;

public abstract class TrafficController {
    private List<TrafficJoiner> joiners = new ArrayList<>();

    public void attach(TrafficJoiner joiner){
        this.joiners.add(joiner);
    }

    public void detach(TrafficJoiner joiner){
        this.joiners.remove(joiner);
    }

    //status 通行状态的标志位 0: 禁止通行 ; 1: 允许通行
    public void trafficNotify(int status){
        if (status==0){
            this.joiners.forEach(TrafficJoiner::stop);

        }
        if (status==1){
            this.joiners.forEach(TrafficJoiner::start);
        }
    }



    //允许通行
    public abstract void pass();

    //禁止通行
    public abstract void noPass();
}
