package cn.xin.learn.community.controller;

import cn.xin.learn.community.entity.dto.forms.FormsDto;
import cn.xin.learn.community.entity.params.forms.PageFormsParam;
import cn.xin.learn.community.entity.params.forms.QueryFormsParam;
import cn.xin.learn.community.entity.params.forms.SaveUpdateFormsParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.FormsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xin
 * @description: 表单控制器
 * @date 2025年02月05日
 */
@RestController
@RequestMapping("forms")
@RequiredArgsConstructor
public class FormsController {
    private final FormsService formsService;

    /**
     * 新增或者修改表单项
     */
    @PostMapping("saveOrUpdateForms")
    public Boolean saveOrUpdateForms(@RequestBody SaveUpdateFormsParam param) {
        return formsService.saveOrUpdateForms(param);
    }

    /**
     * 分页查询表单
     */
    @PostMapping("queryFormsPage")
    public PageVo<FormsDto> queryForms(@RequestBody PageFormsParam param) {
        return formsService.queryFormsPage(param);
    }

    /**
     * 查询表单列表
     */
    @PostMapping("queryFormsList")
    public List<FormsDto> queryFormsList(@RequestBody QueryFormsParam param) {
        return formsService.queryFormsList(param);
    }

    /**
     * 删除表单项
     */
    @GetMapping("deleteForms")
    public Boolean deleteForms(Long formsId) {
        return formsService.deleteForms(formsId);
    }

    /**
     * 查询表单项详情
     */
    @GetMapping("queryFormsDetail")
    public FormsDto queryFormsDetail(Long formsId) {
        return formsService.queryFormsDetail(formsId);
    }
}
