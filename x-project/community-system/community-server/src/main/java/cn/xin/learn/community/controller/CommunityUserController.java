package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.params.PageUserParams;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.CommunityUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
     * 新增或者修改用户
     */
    @PostMapping("saveOrUpdateUser")
    public Boolean saveOrUpdateUser(@RequestBody CommunityUser communityUser) {
        return communityUserService.saveOrUpdateUser(communityUser);
    }

    /**
     * 查询用户列表
     */
    @PostMapping("listUser")
    public PageVo<CommunityUser> listUser(@RequestBody PageUserParams pageUserParams) {
        return communityUserService.queryUserList(pageUserParams);
    }
}

