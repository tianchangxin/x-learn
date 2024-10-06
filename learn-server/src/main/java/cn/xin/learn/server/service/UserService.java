package cn.xin.learn.server.service;

import cn.hutool.json.JSONUtil;
import cn.xin.learn.server.annotations.CostTime;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @author tiancx
 * @description: TODO
 * @date 2024年09月02日
 */
@Service
public class UserService implements ProxyService<UserService> {
    @CostTime
    public void getUser() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("get user");
        getProxy().getUserInfo();
    }

    @CostTime
    public void getUserInfo() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("get user info");
    }

    public static void main(String[] args) {
        String x="{\\\"abTestVersion\\\":2,\\\"channelKey\\\":\\\"2828C4CA-14DD-4E4C-AA83-AE15CECA6A98\\\",\\\"customRecommend\\\":1,\\\"deviceId\\\":\\\"4fac0573d00fecbc\\\",\\\"hasNewClick\\\":false,\\\"includeAroundCityScenery\\\":true,\\\"keyword\\\":\\\"清远\\\",\\\"lat\\\":0.0,\\\"liveCityId\\\":0,\\\"lon\\\":0.0,\\\"memberId\\\":\\\"149597562\\\",\\\"page\\\":0,\\\"pageSize\\\":10,\\\"platId\\\":434,\\\"positionCityId\\\":0,\\\"recommend\\\":1,\\\"refId\\\":0,\\\"searchType\\\":\\\"list\\\",\\\"selectCityId\\\":321,\\\"showFilters\\\":1,\\\"userKey\\\":\\\"149597562\\\"}";
        String jsonString = JSONObject.toJSONString(x);
        System.out.println(JSONUtil.toJsonStr(jsonString));
    }
}
