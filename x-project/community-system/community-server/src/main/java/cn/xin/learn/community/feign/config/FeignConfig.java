package cn.xin.learn.community.feign.config;

import cn.xin.learn.community.client.FeignClient;
import cn.xin.learn.community.feign.SmmsFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static cn.xin.learn.community.feign.UrlConstants.SMMS_URL;

/**
 * @author xin
 * @description: TODO
 * @date 2025年01月27日
 */
@Configuration
public class FeignConfig {
    @Bean("smmsFeign")
    public SmmsFeign smmsFeign() {
        return FeignClient.getInstance().getFeignService(SmmsFeign.class, SMMS_URL);
    }
}
