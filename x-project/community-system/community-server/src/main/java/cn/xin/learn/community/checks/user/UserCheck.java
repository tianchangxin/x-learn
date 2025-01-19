package cn.xin.learn.community.checks.user;

import cn.xin.learn.community.entity.params.user.LoginUserParam;
import cn.xin.learn.community.entity.params.user.SaveUpdateUserParam;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author xin
 * @description: 用户检查
 * @date 2024年12月29日
 */
@Slf4j
public class UserCheck {

    /**
     * 校验注册用户参数是否合法
     *
     * @param userInfo 用户信息
     */
    public static void checkRegisterUserParam(SaveUpdateUserParam userInfo) {
        CommunityAssert.notNull(userInfo, "用户信息不能为空");
        CommunityAssert.notEmpty(userInfo.getUserName(), "用户名不能为空");
        CommunityAssert.notEmpty(userInfo.getPwd(), "密码不能为空");
        CommunityAssert.notNull(userInfo.getUserSex(), "性别不能为空");
        CommunityAssert.notEmpty(userInfo.getEmail(), "邮箱不能为空");
        CommunityAssert.notEmpty(userInfo.getRole(), "角色不能为空");
        CommunityAssert.notNull(userInfo.getDeptId(), "部门id不能为空");
        CommunityAssert.notNull(userInfo.getSuperAdmin(), "是否超管不能为空");
        CommunityAssert.notNull(userInfo.getStatus(), "用户状态不能为空");
    }

    /**
     * 校验登录用户参数是否合法
     */
    public static void checkLoginUserParam(LoginUserParam userInfo) {
        CommunityAssert.notNull(userInfo, "用户信息不能为空");
        //用户名或邮箱不能为空
        CommunityAssert.isTrue(
                Objects.nonNull(userInfo.getUserName())
                        || Objects.nonNull(userInfo.getEmail()),
                "用户名或邮箱不能为空");
        CommunityAssert.notEmpty(userInfo.getPwd(), "密码不能为空");
    }
}
