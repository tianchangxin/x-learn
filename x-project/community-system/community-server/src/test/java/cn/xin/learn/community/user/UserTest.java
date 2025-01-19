package cn.xin.learn.community.user;

import cn.xin.learn.community.entity.dto.user.CommunityUserDto;
import cn.xin.learn.community.entity.params.user.LoginUserParam;
import cn.xin.learn.community.service.CommunityUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author xin
 * @description: 用户测试
 * @date 2025年01月18日
 */
@SpringBootTest
public class UserTest {
    @Resource
    private CommunityUserService userService;

    /**
     * 测试登录
     */
    @Test
    public void testLogin() {
        LoginUserParam param = new LoginUserParam();
        param.setUserName("tcx");
        param.setPwd("123");
        CommunityUserDto login = userService.login(param);
        Assertions.assertNotNull(login);
    }
}
