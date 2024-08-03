package cn.xin.learn.flink.checkpoint;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.runtime.state.filesystem.FsStateBackend;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.concurrent.TimeUnit;

/**
 * @author tiancx
 * @description: checkpoint
 * @date 2024年07月21日
 */
@Slf4j
public class CheckPointDemo {
    //flink run -c cn.xin.learn.flink.checkpoint.CheckPointDemo /Users/tiancx/JavaSE/x-learn/learn-bigdate/learn-flink/target/learn-flink-1.0.0-SNAPSHOT.jar

    //flink run -c cn.xin.learn.flink.checkpoint.CheckPointDemo -s /Users/tiancx/app/flink/checkpoint/842299cee81d913731cad5ca20a09f65/chk-74 /Users/tiancx/JavaSE/x-learn/learn-bigdate/learn-flink/target/learn-flink-1.0.0-SNAPSHOT.jar
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setRuntimeMode(RuntimeExecutionMode.AUTOMATIC);
        //每隔1000ms进行一次checkpoint
        env.enableCheckpointing(2000);
        //存储路径：，这里我选的我自己本地目录，方便一点
        env.setStateBackend(new FsStateBackend("file:/Users/tiancx/app/flink/checkpoint"));
        //web ui上取消任务后，不删除checkpoint目录
        env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);
        env.setRestartStrategy(RestartStrategies.fixedDelayRestart(3, Time.of(10, TimeUnit.SECONDS)));
        env.socketTextStream("localhost", 9999)
                .map(new MapFunction<String, Tuple2<String,Integer>>() {
                    @Override
                    public Tuple2<String, Integer> map(String value) throws Exception {
                        String[] split = value.split(" ");
                        if(StringUtils.equals("bug", split[0])){
                            log.error("Flink程序出现了bug,赶紧去解决");
                            throw new RuntimeException("Flink程序出现了bug");
                        }
                        return Tuple2.of(split[0], Integer.parseInt(split[1]));
                    }
                })
                .keyBy(t -> t.f0)
                .sum(1)
                .print();
        env.execute();

    }
}
