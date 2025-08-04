package cn.xin.learn.community.user;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author xin
 * @description: TODO
 * @date 2025年06月13日
 */
@Data
public class PersonInfo {
    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ExcelProperty(value = "时间1", index = 1)
    private String time1;

    @ExcelProperty(value = "时间2", index = 2, converter = UniversalStringConverter.class)
    private String timeStr;
}
