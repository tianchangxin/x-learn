package cn.xin.learn.java.events;

import java.util.EventObject;

/**
 * @author tiancx
 * @description: 消息事件
 * @date 2024年11月14日
 */
public class MsgEvent extends EventObject {
    private int status;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MsgEvent(Object source) {
        super(source);

    }

    public MsgEvent(Object source, int status) {
        super(source);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
