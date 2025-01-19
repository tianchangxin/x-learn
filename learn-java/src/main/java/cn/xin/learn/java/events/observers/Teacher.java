package cn.xin.learn.java.events.observers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author tiancx
 * @description: 教师-被观察者
 * @date 2024年11月15日
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class Teacher extends Observable {
    private String name;
    private List<String> books;


    public Teacher(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public void setHomework(String homework) {
        log.info("{}布置了作业：{}", name, homework);
        books.add(homework);
        setChanged();
        notifyObservers(homework);
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
