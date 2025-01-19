package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.community.CommunityDto;
import cn.xin.learn.community.entity.params.community.QueryCommunityParam;
import cn.xin.learn.community.entity.params.community.SaveUpdateCommunityParam;
import cn.xin.learn.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 社区信息表;(Community)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:22
 */
@RestController
@RequestMapping("community")
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;

    /**
     * 查询社区信息
     */
    @PostMapping("getCommunity")
    public CommunityDto getCommunity(@RequestBody QueryCommunityParam param) {
        return communityService.queryCommunityOne(param);
    }

    /**
     * 新增或者修改社区信息
     */
    @PostMapping("saveOrUpdateCommunity")
    public Boolean saveOrUpdateCommunity(@Validated @RequestBody SaveUpdateCommunityParam param) {
        return communityService.saveOrUpdateCommunity(param);
    }
}

