package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.GoodsDao;
import cn.xin.learn.community.entity.po.Goods;
import cn.xin.learn.community.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

