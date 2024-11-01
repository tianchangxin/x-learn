package cn.xin.learn.design.behavioral.chain.core;

import cn.xin.learn.design.behavioral.chain.biz.UserRequset;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tiancx
 * @description: 责任链上下文
 * @date 2024年10月27日
 */
@Slf4j
public class ChainContext<T> {

    /**
     * 链路处理器
     */
    private final Map<String, List<ChainHandler>> chainHandlers = new HashMap<>();

    /**
     * 循环一个一个调用处理
     * @param chainFlag 处理标志
     * @param t 参数
     */
    public void handle(String chainFlag, T t) {
        log.info("开始执行链路处理器");
        List<ChainHandler> chainHandlers = this.chainHandlers.get(chainFlag);
        if(CollectionUtils.isNotEmpty(chainHandlers)) {
            for (ChainHandler chainHandler : chainHandlers) {
                chainHandler.handler(t);
            }
        }
    }

    /**
     * 获取处理器
     */
    public ChainContext() {
        this.init();
    }

    public void init() {
        log.info("初始化链路处理器");
        List<ChainHandler> list = new ArrayList<>();
        DirectLeaderChainHandler leaderChainHandler = new DirectLeaderChainHandler();
        DepartmentLeaderChainHandler departmentLeaderChainHandler = new DepartmentLeaderChainHandler();
        list.add(leaderChainHandler);
        list.add(departmentLeaderChainHandler);
        chainHandlers.put("userLeave", list);
    }

    public static void main(String[] args) {
        ChainContext context = new ChainContext<UserRequset>();
        UserRequset requset = new UserRequset();
        requset.setUserName("小新");
        requset.setLeaveDays(5);

        context.handle("userLeave", requset);
    }

}
