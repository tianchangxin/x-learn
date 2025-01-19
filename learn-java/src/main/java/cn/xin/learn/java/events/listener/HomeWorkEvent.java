package cn.xin.learn.java.events.listener;

import lombok.extern.slf4j.Slf4j;

import java.util.EventObject;

/**
 * @author tiancx
 * @description: homework事件
 * @date 2024年11月15日
 */
@Slf4j
public class HomeWorkEvent extends EventObject {

    public HomeWorkEvent(Teacher source) {
        super(source);
    }

    public Teacher getTeacher() {
        return (Teacher) getSource();
    }
}
