package cn.xin.learn.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xin.learn.server.entity.po.Goods;
import cn.xin.learn.server.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品表;(Goods)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@RestController
@RequestMapping("goods")
public class GoodsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param goods 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Goods> page, Goods goods) {
        return success(this.goodsService.page(page, new QueryWrapper<>(goods)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.goodsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param goods 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Goods goods) {
        return success(this.goodsService.save(goods));
    }

    /**
     * 修改数据
     *
     * @param goods 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Goods goods) {
        return success(this.goodsService.updateById(goods));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.goodsService.removeByIds(idList));
    }
}

