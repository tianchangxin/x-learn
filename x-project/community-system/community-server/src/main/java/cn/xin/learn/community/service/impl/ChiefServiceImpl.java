package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.ChiefDao;
import cn.xin.learn.community.entity.dto.chief.ChiefDto;
import cn.xin.learn.community.entity.params.chief.QueryChiefParam;
import cn.xin.learn.community.entity.params.chief.SaveOrUpdateChiefParam;
import cn.xin.learn.community.entity.po.Chief;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.ChiefService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 政务表;(Chief)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@Service("chiefService")
public class ChiefServiceImpl extends ServiceImpl<ChiefDao, Chief> implements ChiefService {


    @Override
    public PageVo<ChiefDto> queryChiefPage(QueryChiefParam chiefParam) {
        LambdaQueryWrapper<Chief> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Objects.nonNull(chiefParam.getChiefTitle()),Chief::getChiefTitle,chiefParam.getChiefTitle())
                .eq(Objects.nonNull(chiefParam.getChiefType()),Chief::getChiefType,chiefParam.getChiefType())
                .like(Objects.nonNull(chiefParam.getChiefContent()),Chief::getChiefContent,chiefParam.getChiefContent())
                .eq(Objects.nonNull(chiefParam.getIsPublish()),Chief::getIsPublish,chiefParam.getIsPublish())
                .orderByDesc(Chief::getChiefId);
        Page<Chief> page = Page.of(chiefParam.getCurrentPage(), chiefParam.getPageSize());
        page = this.page(page, wrapper);
        return PageVo.<ChiefDto>builder()
                .items(BeanUtil.copyToList(page.getRecords(), ChiefDto.class))
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .build();
    }

    @Override
    public Boolean saveOrUpdateChief(SaveOrUpdateChiefParam chiefParam) {
        Chief chief = new Chief();
        if (Objects.isNull(chiefParam.getChiefId())) {
            chiefParam.setIsPublish(1);
        }
        BeanUtil.copyProperties(chiefParam, chief);
        return this.saveOrUpdate(chief);
    }

    @Override
    public Boolean deleteChief(Integer chiefId) {
        return this.removeById(chiefId);
    }


}

