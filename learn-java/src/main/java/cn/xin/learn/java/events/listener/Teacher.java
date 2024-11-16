package cn.xin.learn.java.events.listener;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tiancx
 * @description: 被监听者
 * @date 2024年11月15日
 */
@Data
@Slf4j
public class Teacher {
    private String name;

    private List<String> homeWorks;

    private Set<Student> listeners;

    public Teacher(String name) {
        this.name = name;
        this.homeWorks = new ArrayList<>();
        this.listeners = new HashSet<>();
    }

    public void setHomework(String homework) {
        log.info("{}布置了作业：{}", name, homework);
        homeWorks.add(homework);

        HomeWorkEvent event = new HomeWorkEvent(this);
        /*
         * 在观察者模式中，我们直接调用Observable的notifyObservers来通知被观察者
         * 现在我们只能自己通知了~~
         */
        for (Student listener : listeners) {
            listener.update(event, homework);
        }
    }

    public void addObserver(Student homeworkListener) {
        listeners.add(homeworkListener);
    }


    public static void main(String[] args) {
        Student student1 = new Student("海绵宝宝");
        Student student2 = new Student("章鱼哥");
        Teacher teacher1 = new Teacher("老大");
        teacher1.addObserver(student1);
        teacher1.addObserver(student2);
        teacher1.setHomework("事件机制第一天作业");
    }

}
