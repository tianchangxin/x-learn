package cn.xin.learn.community.controller;

import cn.xin.learn.community.entity.dto.dict.DictDto;
import cn.xin.learn.community.entity.params.dict.PageDictParam;
import cn.xin.learn.community.entity.params.dict.QueryDictParam;
import cn.xin.learn.community.entity.params.dict.SaveUpdateDictParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xin
 * @description: 字典管理
 * @date 2025年01月19日
 */
@RestController
@RequestMapping("dict")
@RequiredArgsConstructor
public class DictController {
    private final DictionaryService dictionaryService;

    /**
     * 保存或更新字典
     */
    @RequestMapping("saveOrUpdateDict")
    public Boolean saveUpdateDict(@Validated @RequestBody SaveUpdateDictParam param) {
        return dictionaryService.saveOrUpdateDictionary(param);
    }

    /**
     * 分页查询字典
     */
    @RequestMapping("pageDict")
    public PageVo<DictDto> pageDict(@Validated @RequestBody PageDictParam param) {
        return dictionaryService.pageDict(param);
    }

    /**
     * 查询字典列表
     */
    @RequestMapping("listDict")
    public List<DictDto> listDict(@Validated @RequestBody QueryDictParam param) {
        return dictionaryService.listDict(param);
    }

}
