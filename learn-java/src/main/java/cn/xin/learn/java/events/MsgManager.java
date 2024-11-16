package cn.xin.learn.java.events;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tiancx
 * @description:
 * @date 2024年11月14日
 */
public class MsgManager {
    static List<MsgListener> msgListeners = new ArrayList<MsgListener>();

    public static void addListener(MsgListener listener) {
        msgListeners.add(listener);
    }

    public static void sendMsg(MsgEvent event) throws Exception {
        notifyListeners(event);
    }

    public static void notifyListeners(MsgEvent event) throws Exception {
        for (MsgListener listener : msgListeners) {
            listener.handleMsg(event);
        }
    }

    public static void main(String[] args) throws Exception {
        MsgManager.addListener(new MsgListener() {
            @Override
            public void handleMsg(MsgEvent event) {
                System.out.println("MsgListenerA," + event.getStatus());
            }
        });
        MsgManager.addListener(new MsgListener() {
            @Override
            public void handleMsg(MsgEvent event) {
                System.out.println("MsgListenerB," + event.getStatus());
            }
        });
        MsgEvent msg1 = new MsgEvent("test", 11);
        sendMsg(msg1);
    }

}
