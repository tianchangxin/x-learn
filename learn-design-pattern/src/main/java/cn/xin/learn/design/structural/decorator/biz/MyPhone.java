package cn.xin.learn.design.structural.decorator.biz;

import cn.xin.learn.design.structural.decorator.core.Phone;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancx
 * @description: MyPhone - 原生手机
 * @date 2024年10月27日
 */
@Slf4j
public class MyPhone implements Phone {

    /**
     * 原始功能
     */
    @Override
    public void show() {
        log.info("原始功能");
    }
}
