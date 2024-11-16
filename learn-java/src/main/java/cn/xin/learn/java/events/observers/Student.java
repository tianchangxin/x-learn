package cn.xin.learn.java.events.observers;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author tiancx
 * @description: 学生-观察者
 * @date 2024年11月15日
 */
@Slf4j
public class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
        log.info("{}收到了老大的通知,内容：{}", name, arg);
    }
}
