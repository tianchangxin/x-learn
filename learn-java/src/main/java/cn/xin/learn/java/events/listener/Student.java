package cn.xin.learn.java.events.listener;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.EventListener;

/**
 * @author tiancx
 * @description: 监听器
 * @date 2024年11月15日
 */
@Slf4j
@Data
public class Student implements EventListener {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void update(HomeWorkEvent event, String msg) {
        log.info("{}收到了{}的通知,内容：{}", name, event.getTeacher().getName(), msg);
    }
}
