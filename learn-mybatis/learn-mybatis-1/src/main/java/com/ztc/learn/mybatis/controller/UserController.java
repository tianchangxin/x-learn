package com.ztc.learn.mybatis.controller;

import com.ztc.learn.mybatis.modle.vo.UserVo;
import com.ztc.learn.mybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping(value = "role")
    public List<UserVo> getUserByRole(String role){
        return userService.getUserByRole(role);
    }
}
