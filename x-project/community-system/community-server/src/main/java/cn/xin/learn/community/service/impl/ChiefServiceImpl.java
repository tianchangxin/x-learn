package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.ChiefDao;
import cn.xin.learn.community.entity.po.Chief;
import cn.xin.learn.community.service.ChiefService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 政务表;(Chief)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@Service("chiefService")
public class ChiefServiceImpl extends ServiceImpl<ChiefDao, Chief> implements ChiefService {
    @Resource
    private ChiefDao chiefDao;

    public Object test() {
        return baseMapper.selectById(1);
    }
}

