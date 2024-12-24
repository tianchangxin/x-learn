package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.IntegralDao;
import cn.xin.learn.server.entity.po.Integral;
import cn.xin.learn.server.service.IntegralService;
import org.springframework.stereotype.Service;

/**
 * 积分;(Integral)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@Service("integralService")
public class IntegralServiceImpl extends ServiceImpl<IntegralDao, Integral> implements IntegralService {

}

