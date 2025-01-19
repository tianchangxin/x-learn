package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.user.CommunityUserDto;
import cn.xin.learn.community.entity.params.user.LoginUserParam;
import cn.xin.learn.community.entity.params.user.PageUserParam;
import cn.xin.learn.community.entity.params.user.SaveUpdateUserParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.CommunityUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 社区用户表;(CommunityUser)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("communityUser")
public class CommunityUserController {
    private final CommunityUserService communityUserService;

    /**
     * 注册用户
     */
    @PostMapping("registerUser")
    public Boolean registerUser(@Validated @RequestBody SaveUpdateUserParam params) {
        return communityUserService.registerUser(params);
    }

    /**
     * 登录
     */
    @PostMapping("loginUser")
    public CommunityUserDto login(@Validated @RequestBody LoginUserParam param) {
        return communityUserService.login(param);
    }


    /**
     * 新增或者修改用户
     */
    @PostMapping("saveOrUpdateUser")
    public Boolean saveOrUpdateUser(@Validated @RequestBody SaveUpdateUserParam params) {
        return communityUserService.saveOrUpdateUser(params);
    }

    /**
     * 查询用户列表
     */
    @PostMapping("listUser")
    public PageVo<CommunityUser> listUser(@RequestBody PageUserParam pageUserParam) {
        return communityUserService.queryUserList(pageUserParam);
    }

    /**
     * 删除用户
     */
    @PostMapping("deleteUser")
    public Boolean deleteUser(@RequestBody List<Long> userIds) {
        return communityUserService.deleteUser(userIds);
    }
}

