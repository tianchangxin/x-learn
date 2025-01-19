package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.DictionaryDao;
import cn.xin.learn.community.entity.dto.dict.DictDto;
import cn.xin.learn.community.entity.params.dict.PageDictParam;
import cn.xin.learn.community.entity.params.dict.QueryDictParam;
import cn.xin.learn.community.entity.params.dict.SaveUpdateDictParam;
import cn.xin.learn.community.entity.po.Dictionary;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.DictionaryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author tiancx
 * @description 针对表【dictionary(;)】的数据库操作Service实现
 * @createDate 2025-01-19 20:24:15
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryDao, Dictionary>
        implements DictionaryService {

    /**
     * 新增或者修改字典
     *
     * @param param 字典信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveOrUpdateDictionary(SaveUpdateDictParam param) {
        Dictionary copied = BeanUtil.copyProperties(param, Dictionary.class);
        return saveOrUpdate(copied);
    }

    /**
     * 分页查询字典
     *
     * @param param 分页参数
     */
    @Override
    public PageVo<DictDto> pageDict(PageDictParam param) {
        LambdaQueryWrapper<Dictionary> wrapper = new LambdaQueryWrapper<Dictionary>()
                .like(StringUtils.isNotEmpty(param.getDictName()), Dictionary::getDictName, param.getDictName())
                .like(StringUtils.isNotEmpty(param.getDictCode()), Dictionary::getDictCode, param.getDictCode())
                .eq(Objects.nonNull(param.getDictStatus()), Dictionary::getDictStatus, param.getDictStatus());
        Page<Dictionary> page = Page.of(param.getCurrentPage(), param.getPageSize());
        page = this.page(page, wrapper);
        return PageVo.<DictDto>builder()
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .items(BeanUtil.copyToList(page.getRecords(), DictDto.class))
                .build();
    }

    /**
     * 查询列表
     *
     * @param param
     */
    @Override
    public List<DictDto> listDict(QueryDictParam param) {
        LambdaQueryWrapper<Dictionary> wrapper = new LambdaQueryWrapper<Dictionary>()
                .like(StringUtils.isNotEmpty(param.getDictName()), Dictionary::getDictName, param.getDictName())
                .like(StringUtils.isNotEmpty(param.getDictCode()), Dictionary::getDictCode, param.getDictCode())
                .eq(Objects.nonNull(param.getDictStatus()), Dictionary::getDictStatus, param.getDictStatus());
        List<Dictionary> list = this.list(wrapper);
        return BeanUtil.copyToList(list, DictDto.class);
    }
}




