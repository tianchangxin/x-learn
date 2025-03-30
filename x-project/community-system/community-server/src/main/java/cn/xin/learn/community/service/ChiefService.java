package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.chief.ChiefDto;
import cn.xin.learn.community.entity.params.chief.QueryChiefParam;
import cn.xin.learn.community.entity.params.chief.SaveOrUpdateChiefParam;
import cn.xin.learn.community.entity.po.Chief;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 政务表;(Chief)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
public interface ChiefService extends IService<Chief> {

    PageVo<ChiefDto> queryChiefPage(QueryChiefParam chiefParam);

    Boolean saveOrUpdateChief(SaveOrUpdateChiefParam chiefParam);

    Boolean deleteChief(Integer chiefId);
}

