package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.community.CommunityDto;
import cn.xin.learn.community.entity.params.community.QueryCommunityParam;
import cn.xin.learn.community.entity.params.community.SaveUpdateCommunityParam;
import cn.xin.learn.community.entity.po.Community;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 社区信息表;(Community)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
public interface CommunityService extends IService<Community> {
    /**
     * 通过ID查询单条数据
     */
    CommunityDto queryCommunityOne(QueryCommunityParam param);

    /**
     * 保存或更新数据
     */
    boolean saveOrUpdateCommunity(SaveUpdateCommunityParam param);

    /**
     * 删除数据-单条
     */
    boolean deleteCommunityOne(Long id);
}

