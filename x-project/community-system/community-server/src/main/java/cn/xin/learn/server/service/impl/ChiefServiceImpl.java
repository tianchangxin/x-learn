package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.ChiefDao;
import cn.xin.learn.server.entity.po.Chief;
import cn.xin.learn.server.service.ChiefService;
import org.springframework.stereotype.Service;

/**
 * 政务表;(Chief)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@Service("chiefService")
public class ChiefServiceImpl extends ServiceImpl<ChiefDao, Chief> implements ChiefService {

}

