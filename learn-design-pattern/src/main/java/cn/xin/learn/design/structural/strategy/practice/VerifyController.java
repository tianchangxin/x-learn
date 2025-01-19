package cn.xin.learn.design.structural.strategy.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiancx
 * @description: 验证控制类
 * @date 2024年11月16日
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/reset")
public class VerifyController {
    private final VerifyService verifyService;

    @PostMapping("verify")
    public String verify(@RequestBody VerifyParam param) {
        return verifyService.verify(param);
    }

    @PostMapping("verifyYes")
    public String verifyYes(@RequestBody VerifyParam param) {
        return verifyService.verifyYes(param);
    }
}
