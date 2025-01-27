package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.integral.IntegralDto;
import cn.xin.learn.community.entity.params.integral.PageIntegralParam;
import cn.xin.learn.community.entity.params.integral.QueryIntegralParam;
import cn.xin.learn.community.entity.params.integral.SaveUpdateIntegralParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.IntegralService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 积分;(Integral)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@RestController
@RequestMapping("integral")
@RequiredArgsConstructor
public class IntegralController {
    private final IntegralService integralService;

    /**
     * 新增或保存积分
     */
    @PostMapping("saveUpdateIntegral")
    public Boolean saveUpdateIntegral(@Validated @RequestBody SaveUpdateIntegralParam param) {
        return integralService.saveUpdateIntegral(param);
    }

    /**
     * 分页查询积分
     */
    @PostMapping("queryIntegralPage")
    public PageVo<IntegralDto> queryIntegralPage(@Validated @RequestBody PageIntegralParam param) {
        return integralService.queryIntegralPage(param);
    }

    /**
     * 查询积分列表
     */
    @PostMapping("queryUserIntegral")
    public List<IntegralDto> queryUserIntegral(@Validated @RequestBody QueryIntegralParam param) {
        return integralService.queryUserIntegral(param);
    }

    /**
     * 删除积分记录
     */
    @GetMapping("deleteIntegral")
    public Boolean deleteIntegral(Long integralId) {
        return integralService.deleteIntegral(integralId);
    }

}

