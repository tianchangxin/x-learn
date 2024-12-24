package cn.xin.learn.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xin.learn.server.entity.po.CommunityUser;
import cn.xin.learn.server.service.CommunityUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 社区用户表;(CommunityUser)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:21
 */
@RestController
@RequestMapping("communityUser")
public class CommunityUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CommunityUserService communityUserService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param communityUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CommunityUser> page, CommunityUser communityUser) {
        return success(this.communityUserService.page(page, new QueryWrapper<>(communityUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.communityUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param communityUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CommunityUser communityUser) {
        return success(this.communityUserService.save(communityUser));
    }

    /**
     * 修改数据
     *
     * @param communityUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CommunityUser communityUser) {
        return success(this.communityUserService.updateById(communityUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.communityUserService.removeByIds(idList));
    }
}

