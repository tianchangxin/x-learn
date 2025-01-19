package cn.xin.learn.java.events;

import java.util.EventListener;

/**
 * @author tiancx
 * @description: 监听者接口
 * @date 2024年11月14日
 */
public interface MsgListener extends EventListener {
    void handleMsg(MsgEvent event);
}
