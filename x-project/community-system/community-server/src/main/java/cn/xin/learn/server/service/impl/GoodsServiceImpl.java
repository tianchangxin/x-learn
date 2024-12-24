package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.GoodsDao;
import cn.xin.learn.server.entity.po.Goods;
import cn.xin.learn.server.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * 商品表;(Goods)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {

}

