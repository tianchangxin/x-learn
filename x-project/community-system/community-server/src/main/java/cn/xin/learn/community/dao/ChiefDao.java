package cn.xin.learn.community.dao;

import cn.xin.learn.community.entity.po.Chief;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 政务表;(Chief)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@Mapper
public interface ChiefDao extends BaseMapper<Chief> {
    /**
     * 查所有
     */
    List<Chief> queryAll();
}

