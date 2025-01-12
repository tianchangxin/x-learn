package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.CommunityDao;
import cn.xin.learn.community.entity.dto.community.CommunityDto;
import cn.xin.learn.community.entity.params.community.QueryCommunityParam;
import cn.xin.learn.community.entity.params.community.SaveUpdateCommunityParam;
import cn.xin.learn.community.entity.po.Community;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.service.CommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 社区信息表;(Community)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@Service("communityService")
public class CommunityServiceImpl extends ServiceImpl<CommunityDao, Community> implements CommunityService {

    /**
     * 通过ID查询单条数据
     *
     * @param param 社区信息
     */
    @Override
    public CommunityDto queryCommunityOne(QueryCommunityParam param) {
        Community community;
        // 如果id为空，则查询第一条数据,理论只会出现一条数据
        if (Objects.isNull(param) || Objects.isNull(param.getCommunityId())) {
            List<Community> communities = this.list();
            community = Optional.ofNullable(communities)
                    .orElse(Collections.emptyList())
                    .stream().findFirst().orElse(new Community());
        } else {
            Long communityId = param.getCommunityId();
            community = getById(communityId);
        }
        CommunityDto communityDto = new CommunityDto();
        BeanUtil.copyProperties(community, communityDto);
        return communityDto;
    }

    /**
     * 保存或更新数据
     *
     * @param param 社区信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateCommunity(SaveUpdateCommunityParam param) {
        Community community = new Community();
        BeanUtil.copyProperties(param, community);
        //先查询是否已经有社区信息，有的话不让新增
        List<Community> list = list();
        //如果社区信息不为空，则不让新增
        if (CollectionUtils.isNotEmpty(list) && Objects.isNull(param.getCommunityId())) {
            CommunityAssert.fail("社区信息已存在，不可新增");
            return false;
        }
        return saveOrUpdate(community);
    }

    /**
     * 删除数据-单条
     *
     * @param id id
     */
    @Override
    public boolean deleteCommunityOne(Long id) {
        CommunityAssert.notNull(id, "id不能为空");
        return removeById(id);
    }
}

