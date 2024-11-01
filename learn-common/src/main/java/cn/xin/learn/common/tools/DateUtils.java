package cn.xin.learn.common.tools;

import java.time.LocalDate;

/**
 * @author tiancx
 * @description: 日期工具类
 * @date 2024年11月01日
 */
public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";

    /**
     * 返回当天
     */
    public static String getToday() {
       return LocalDate.now().toString();
    }

    /**
     * 返回往后或往前 x 天
     * @param x 天数
     */
    public static String getDate(int x) {
        return LocalDate.now().plusDays(x).toString();
    }



    public static void main(String[] args) {
        System.out.println(getToday());
    }

}
