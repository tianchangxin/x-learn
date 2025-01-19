package cn.xin.learn.community.communityinfo;

import cn.xin.learn.community.entity.dto.community.CommunityDto;
import cn.xin.learn.community.entity.params.community.SaveUpdateCommunityParam;
import cn.xin.learn.community.exceptions.CommunityException;
import cn.xin.learn.community.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author xin
 * @description: 社区测试
 * @date 2025年01月12日
 */
@SpringBootTest
@Slf4j
public class CommunityTest {
    @Resource
    private CommunityService communityService;

    /**
     * 测试新增
     */
    @Test
    public void testSaveCommunity() {
        SaveUpdateCommunityParam param = new SaveUpdateCommunityParam();
        param.setCommunityName("社区1");
        param.setCommunityHeader("社区负责人1");
        param.setCommunityHeaderId(1L);
        param.setCommunityDescribe("社区描述1");
        param.setCommunityUser(1);
        CommunityDto communityDto = communityService.queryCommunityOne(null);
        if (Objects.nonNull(communityDto)) {
            Assertions.assertThrows(CommunityException.class, () -> {
                log.info("社区已存在，不能新增");
                communityService.saveOrUpdateCommunity(param);
            });
        } else {
            boolean b = communityService.saveOrUpdateCommunity(param);
            Assertions.assertTrue(b);
        }
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdateCommunity() {
        SaveUpdateCommunityParam param = new SaveUpdateCommunityParam();
        param.setCommunityId(2L);
        param.setCommunityName("社区1-修改");
        param.setCommunityHeader("社区负责人1");
        param.setCommunityHeaderId(1L);
        param.setCommunityDescribe("社区描述1");
        param.setCommunityUser(1);
        boolean b = communityService.saveOrUpdateCommunity(param);
        Assertions.assertTrue(b);
        CommunityDto communityDto = communityService.queryCommunityOne(null);
        Assertions.assertEquals(2L, communityDto.getCommunityId());
        Assertions.assertEquals("社区1-修改", communityDto.getCommunityName());
        // 还原数据
        param.setCommunityName("社区1");
        communityService.saveOrUpdateCommunity(param);
        CommunityDto bak = communityService.queryCommunityOne(null);
        Assertions.assertEquals(2L, bak.getCommunityId());
        Assertions.assertEquals("社区1", bak.getCommunityName());
    }

    /**
     * 测试查询
     */
    @Test
    public void testQueryCommunity() {
        CommunityDto communityDto = communityService.queryCommunityOne(null);
        Assertions.assertEquals(2L, communityDto.getCommunityId());
        Assertions.assertEquals("社区1", communityDto.getCommunityName());
    }
    
}
