package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.dict.DictDto;
import cn.xin.learn.community.entity.params.dict.PageDictParam;
import cn.xin.learn.community.entity.params.dict.QueryDictParam;
import cn.xin.learn.community.entity.params.dict.SaveUpdateDictParam;
import cn.xin.learn.community.entity.po.Dictionary;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author tiancx
 * @description 针对表【dictionary(;)】的数据库操作Service
 * @createDate 2025-01-19 20:24:15
 */
public interface DictionaryService extends IService<Dictionary> {
    /**
     * 新增或者修改字典
     */
    Boolean saveOrUpdateDictionary(SaveUpdateDictParam param);

    /**
     * 分页查询字典
     */
    PageVo<DictDto> pageDict(PageDictParam param);

    /**
     * 查询列表
     */
    List<DictDto> listDict(QueryDictParam param);

    /**
     * 删除字典
     */
    Boolean deleteDict(Long id);
}
