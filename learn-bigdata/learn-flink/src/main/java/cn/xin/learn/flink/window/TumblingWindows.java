package cn.xin.learn.flink.window;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.WindowAssigner;
import org.apache.flink.streaming.api.windowing.time.Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author tiancx
 * @description: 滚动窗口
 * @date 2024年08月11日
 */
public class TumblingWindows {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //每隔10秒统计不同用户的点击量
        env.socketTextStream("localhost", 9999)
                .map(value -> {
                    UserClick userClick = new UserClick();
                    userClick.userId = value;
                    userClick.clickTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
                    return userClick;
                })
                .keyBy(UserClick::getUserId)
                .window(TumblingProcessingTimeWindows.of(Time.seconds(10)))
                .sum("clickCount")
                .print();


        env.execute();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserClick {
        private String userId;
        private String clickTime;
        private Integer clickCount = 1;
    }

}
