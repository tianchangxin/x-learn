package cn.xin.learn.server.wordsegm;

import com.huaban.analysis.jieba.JiebaSegmenter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xin
 * @description: 分词测试类
 * @date 2025年02月19日
 */
@Slf4j
public class WordSegmTest {

    @Test
    public void testWordSegmDemo() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences =
                new String[]{"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
        for (String sentence : sentences) {
            log.info("Search模式:{}", segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH));
        }
        log.info("===================================");
        for (String sentence : sentences) {
            log.info("Index模式{}", segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX));
        }
    }
}
