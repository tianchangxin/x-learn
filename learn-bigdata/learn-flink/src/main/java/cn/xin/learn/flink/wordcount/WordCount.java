package cn.xin.learn.flink.wordcount;

import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author tiancx
 * @description: wordcount
 * @date 2024年08月17日
 */
public class WordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.fromElements("hello world", "hello flink", "hello world")
                        .flatMap(new FlatMapFunction<String, Tuple2<String,Integer>>() {
                            @Override
                            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                                String[] split = value.split(" ");
                                for (String s : split) {
                                    out.collect(new Tuple2<>(s,1));
                                }
                            }
                        })
                        .keyBy(t -> t.f0)
                        .sum(1)
                        .print("单词统计");
        JobExecutionResult execute = env.execute();
    }
}
