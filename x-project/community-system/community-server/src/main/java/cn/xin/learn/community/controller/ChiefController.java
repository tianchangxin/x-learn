package cn.xin.learn.community.controller;


import cn.xin.learn.community.service.ChiefService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 政务表;(Chief)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@RestController
@RequestMapping("chief")
@RequiredArgsConstructor
public class ChiefController {
    private final ChiefService chiefService;

    @RequestMapping("list")
    public Object list() {
        return chiefService.test();
    }

}

