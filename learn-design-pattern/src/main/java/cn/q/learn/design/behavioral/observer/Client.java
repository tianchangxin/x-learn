package cn.q.learn.design.behavioral.command;

import cn.q.learn.design.behavioral.command.biz.Car;
import cn.q.learn.design.behavioral.command.biz.PoliceMan;
import cn.q.learn.design.behavioral.command.biz.TrafficLight;
import cn.q.learn.design.behavioral.command.biz.WalkMan;
import cn.q.learn.design.behavioral.command.core.TrafficController;
import cn.q.learn.design.behavioral.command.core.TrafficJoiner;

public class Client {
    public static void main(String[] args) {
        //todo 模拟业务场景

        // 1.创建控制者
        TrafficController light = new TrafficLight();

        // 2.创建警察
        TrafficController policeMan = new PoliceMan();

        // 2.构建参与者
        TrafficJoiner car1 = new Car("福特GT");
        TrafficJoiner car2 = new Car("拉法");
        TrafficJoiner car3 = new Car("vahala");

        TrafficJoiner man1 = new WalkMan("xin");
        TrafficJoiner man2 = new WalkMan("张学友");
        TrafficJoiner man3 = new WalkMan("陈冠希");
        // 3.组建交通路口
        light.attach(car1);

        //4.控制着的状态变化
        light.pass();
        light.detach(car1);
        light.detach(car2);
        light.detach(car3);
        light.pass();

        policeMan.attach(man1);
        policeMan.attach(man2);
        policeMan.pass();
        policeMan.detach(man1);
        policeMan.detach(man2);
        policeMan.attach(man3);
        policeMan.noPass();

    }
}
