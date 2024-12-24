package cn.xin.learn.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xin.learn.server.entity.po.Chief;
import cn.xin.learn.server.service.ChiefService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 政务表;(Chief)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@RestController
@RequestMapping("chief")
public class ChiefController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ChiefService chiefService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param chief 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Chief> page, Chief chief) {
        return success(this.chiefService.page(page, new QueryWrapper<>(chief)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.chiefService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param chief 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Chief chief) {
        return success(this.chiefService.save(chief));
    }

    /**
     * 修改数据
     *
     * @param chief 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Chief chief) {
        return success(this.chiefService.updateById(chief));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.chiefService.removeByIds(idList));
    }
}

