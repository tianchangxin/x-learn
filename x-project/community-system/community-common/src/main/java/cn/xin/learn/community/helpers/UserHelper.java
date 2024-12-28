package cn.xin.learn.community.helpers;

import cn.xin.learn.community.entity.po.CommunityUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

import static cn.xin.learn.community.constants.SimpleConstant.MIDDLE_LINE;

/**
 * @author xin
 * @description: 用户帮助类
 * @date 2024年12月28日
 */
@Data
@Slf4j
public class UserHelper {
    private static final ThreadLocal<CommunityUser> threadLocal = new ThreadLocal<>();

    /**
     * 获取当前用户
     */
    public static CommunityUser getCurrentUser() {
        return threadLocal.get();
    }

    /**
     * 设置当前用户
     */
    public static void setCurrentUser(CommunityUser user) {
        threadLocal.set(user);
    }

    /**
     * 移除当前用户
     */
    public static void removeCurrentUser() {
        threadLocal.remove();
    }

    /**
     * 获取用户id-名称
     */
    public static String getUserIdAndName() {
        CommunityUser user = getCurrentUser();
        if (Objects.isNull(user)) {
            return Strings.EMPTY;
        }
        return user.getUserId() + MIDDLE_LINE + user.getUserName();
    }

}
