package cn.xin.learn.community.user;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author xin
 * @description: TODO
 * @date 2025年06月13日
 */
public class RawStringReadListener extends AnalysisEventListener<Map<Integer, String>> {
    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        System.out.println("Row: " + data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }
}
