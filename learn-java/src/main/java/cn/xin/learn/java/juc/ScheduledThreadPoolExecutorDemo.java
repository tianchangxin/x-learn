package cn.xin.learn.java.juc;

import com.alibaba.fastjson2.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xin
 * @description: ScheduledThreadPoolExecutorDemo
 * @date 2025年05月05日
 */
public class ScheduledThreadPoolExecutorDemo {
    private static final ScheduledExecutorService executor = new
            ScheduledThreadPoolExecutor(2, Executors.defaultThreadFactory());

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String arg = args[0];
        JSONObject parsed = JSONObject.parseObject(arg);
        System.out.println(parsed);
        // 新建一个固定延迟时间的计划任务
        executor.scheduleWithFixedDelay(() -> {
            if (haveMsgAtCurrentTime()) {
                System.out.println(df.format(new Date()));
                System.out.println("大家注意了，我要发消息了");
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public static boolean haveMsgAtCurrentTime() {
        return true;
    }
}
