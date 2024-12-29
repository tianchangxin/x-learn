package cn.xin.learn.community.exceptions.asserts;

import cn.xin.learn.community.exceptions.CommunityException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;


/**
 * @author xin
 * @description: 社区断言
 * @date 2024年12月29日
 */
@Slf4j
public class CommunityAssert extends Assert {
    /**
     * 断言为真
     *
     * @param expression 表达式：如果为false，则抛出异常、如果为true，则不做任何操作
     * @param message    异常信息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new CommunityException(message);
        }
    }

    /**
     * 字符串不能为空
     *
     * @param str 字符串：如果为空，则抛出异常
     */
    public static void notEmpty(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw new CommunityException(message);
        }
    }

    /**
     * 失败
     */
    public static void fail(String message) {
        throw new CommunityException(message);
    }

}
