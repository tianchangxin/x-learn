package cn.xin.learn.community.feign;

import cn.xin.learn.community.client.FeignClient;
import org.junit.jupiter.api.Test;

/**
 * @author xin
 * @description: 远程调用feign
 * @date 2025年01月27日
 */
public class FeignTest {
    @Test
    public void testFeign() {
        SmmsFeign smmsFeign = FeignClient.getInstance().getFeignService(SmmsFeign.class, UrlConstants.COMMUNITY_SYSTEM_URL);
        Object test = smmsFeign.myfeign();
        System.out.println("test = " + test);
    }
}
