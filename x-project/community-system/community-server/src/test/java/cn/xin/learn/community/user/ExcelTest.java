package cn.xin.learn.community.user;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xin
 * @description: TODO
 * @date 2025年06月13日
 */
public class ExcelTest {

    @Test
    public void testExcel() {

        String filePath = "/Users/tiancx/Desktop/工作簿1.xlsx"; // 替换为实际路径
        try (InputStream inputStream = new FileInputStream(filePath)) {
            EasyExcel.read(inputStream)
                    .headRowNumber(1) // 第一行是表头
                    .registerConverter(new UniversalStringConverter()) // 不一定必须
                    .sheet()
                    .registerReadListener(new RawStringReadListener())
                    .doRead();

//            for (PersonInfo info : list) {
//                System.out.println(info);
//            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
