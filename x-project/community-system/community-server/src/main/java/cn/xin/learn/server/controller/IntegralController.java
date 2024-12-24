package cn.xin.learn.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xin.learn.server.entity.po.Integral;
import cn.xin.learn.server.service.IntegralService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 积分;(Integral)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@RestController
@RequestMapping("integral")
public class IntegralController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private IntegralService integralService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param integral 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Integral> page, Integral integral) {
        return success(this.integralService.page(page, new QueryWrapper<>(integral)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.integralService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param integral 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Integral integral) {
        return success(this.integralService.save(integral));
    }

    /**
     * 修改数据
     *
     * @param integral 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Integral integral) {
        return success(this.integralService.updateById(integral));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.integralService.removeByIds(idList));
    }
}

