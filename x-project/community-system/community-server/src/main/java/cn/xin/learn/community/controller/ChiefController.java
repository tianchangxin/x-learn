package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.chief.ChiefDto;
import cn.xin.learn.community.entity.params.chief.QueryChiefParam;
import cn.xin.learn.community.entity.params.chief.SaveOrUpdateChiefParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.ChiefService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 政务表;(Chief)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@RestController
@RequestMapping("chief")
@RequiredArgsConstructor
public class ChiefController {

    @Autowired
    private final ChiefService chiefService;


    @RequestMapping("queryChiefPage")
    public PageVo<ChiefDto> queryChiefPage(@RequestBody QueryChiefParam chiefParam) {
        return chiefService.queryChiefPage(chiefParam);
    }

    @RequestMapping("saveOrUpdateChief")
    public Boolean saveOrUpdateChief(@RequestBody SaveOrUpdateChiefParam chiefParam) {
        return chiefService.saveOrUpdateChief(chiefParam);
    }

    @RequestMapping("deleteChief")
    public Boolean deleteChief(Integer chiefId) {
        return chiefService.deleteChief(chiefId);
    }

}

