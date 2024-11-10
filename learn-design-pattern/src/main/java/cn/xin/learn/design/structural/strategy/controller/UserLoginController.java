package cn.xin.learn.design.structural.strategy.controller;

import cn.xin.learn.design.structural.strategy.design.UserInfo;
import cn.xin.learn.design.structural.strategy.design.UserLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tiancx
 * @description: 用户登录控制层
 * @date 2024年11月10日
 */
@RestController
@RequestMapping("userLogin")
public class UserLoginController {
    @Resource
    private UserLoginService userLoginService;

    @PostMapping("/valid")
    public String valid(@RequestBody UserInfo param) {
        return userLoginService.valid(param);
    }
}
