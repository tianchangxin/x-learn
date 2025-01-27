package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.integral.IntegralDto;
import cn.xin.learn.community.entity.params.integral.PageIntegralParam;
import cn.xin.learn.community.entity.params.integral.QueryIntegralParam;
import cn.xin.learn.community.entity.params.integral.SaveUpdateIntegralParam;
import cn.xin.learn.community.entity.po.Integral;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 积分;(Integral)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
public interface IntegralService extends IService<Integral> {

    /**
     * 新增或保存积分
     */
    Boolean saveUpdateIntegral(SaveUpdateIntegralParam param);

    /**
     * 分页查询积分
     */
    PageVo<IntegralDto> queryIntegralPage(PageIntegralParam param);

    /**
     * 查询用户积分列表
     */
    List<IntegralDto> queryUserIntegral(QueryIntegralParam param);

    /**
     * 删除积分记录
     */
    Boolean deleteIntegral(Long integralId);
}

