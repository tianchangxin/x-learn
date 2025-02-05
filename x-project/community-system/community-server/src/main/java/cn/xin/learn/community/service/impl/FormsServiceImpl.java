package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.FormsMapper;
import cn.xin.learn.community.entity.dto.forms.FormsDto;
import cn.xin.learn.community.entity.params.forms.PageFormsParam;
import cn.xin.learn.community.entity.params.forms.QueryFormsParam;
import cn.xin.learn.community.entity.params.forms.SaveUpdateFormsParam;
import cn.xin.learn.community.entity.po.Forms;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.service.FormsService;
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
 * @description 针对表【forms(;)】的数据库操作Service实现
 * @createDate 2025-01-19 20:31:34
 */
@Service
public class FormsServiceImpl extends ServiceImpl<FormsMapper, Forms>
        implements FormsService {

    /**
     * 新增或修改表单
     *
     * @param param 表单信息
     * @return 是否新增或修改成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOrUpdateForms(SaveUpdateFormsParam param) {
        Forms forms = BeanUtil.copyProperties(param, Forms.class);
        return saveOrUpdate(forms);
    }

    /**
     * 删除表单
     *
     * @param formsId 表单ID
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteForms(Long formsId) {
        CommunityAssert.notNull(formsId, "表单ID不能为空");
        return this.removeById(formsId);
    }

    /**
     * 分页查询表单列表
     *
     * @param param 分页参数
     * @return 表单列表
     */
    @Override
    public PageVo<FormsDto> queryFormsPage(PageFormsParam param) {
        LambdaQueryWrapper<Forms> wrapper = new LambdaQueryWrapper<Forms>()
                .like(StringUtils.isNotEmpty(param.getFormsTitle()), Forms::getFormsTitle, param.getFormsTitle())
                .eq(StringUtils.isNotEmpty(param.getFormsType()), Forms::getFormsType, param.getFormsType())
                .eq(Objects.nonNull(param.getFormsMustFill()), Forms::getFormsMustFill, param.getFormsMustFill())
                .eq(Objects.nonNull(param.getFormsStatus()), Forms::getFormsStatus, param.getFormsStatus())
                .like(StringUtils.isNotEmpty(param.getFormsRemark()), Forms::getFormsRemark, param.getFormsRemark());

        Page<Forms> page = Page.of(param.getCurrentPage(), param.getPageSize());
        page = this.page(page, wrapper);
        return PageVo.<FormsDto>builder()
                .items(BeanUtil.copyToList(page.getRecords(), FormsDto.class))
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .build();
    }

    /**
     * 查询表单列表
     *
     * @param param 查询参数
     * @return 表单列表
     */
    @Override
    public List<FormsDto> queryFormsList(QueryFormsParam param) {
        LambdaQueryWrapper<Forms> wrapper = new LambdaQueryWrapper<Forms>()
                .like(StringUtils.isNotEmpty(param.getFormsTitle()), Forms::getFormsTitle, param.getFormsTitle())
                .eq(StringUtils.isNotEmpty(param.getFormsType()), Forms::getFormsType, param.getFormsType())
                .eq(Objects.nonNull(param.getFormsMustFill()), Forms::getFormsMustFill, param.getFormsMustFill())
                .eq(Objects.nonNull(param.getFormsStatus()), Forms::getFormsStatus, param.getFormsStatus())
                .like(StringUtils.isNotEmpty(param.getFormsRemark()), Forms::getFormsRemark, param.getFormsRemark());
        List<Forms> formsList = this.list(wrapper);
        return BeanUtil.copyToList(formsList, FormsDto.class);
    }

    /**
     * 查询表单详情
     *
     * @param formsId 表单ID
     * @return 表单详情
     */
    @Override
    public FormsDto queryFormsDetail(Long formsId) {
        return BeanUtil.copyProperties(this.getById(formsId), FormsDto.class);
    }
}




