package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.IntegralDao;
import cn.xin.learn.community.entity.po.Integral;
import cn.xin.learn.community.service.IntegralService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

