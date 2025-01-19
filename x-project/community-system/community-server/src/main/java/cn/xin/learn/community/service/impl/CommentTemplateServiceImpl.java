package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.CommentTemplateDao;
import cn.xin.learn.community.entity.dto.comment.CommentTemplateDto;
import cn.xin.learn.community.entity.params.comment.PageCommentTemplateParam;
import cn.xin.learn.community.entity.params.comment.SaveUpdateCommentTemplateParam;
import cn.xin.learn.community.entity.po.CommentTemplate;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.service.CommentTemplateService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * 评价模板;(CommentTemplate)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@Service("commentTemplateService")
public class CommentTemplateServiceImpl extends ServiceImpl<CommentTemplateDao, CommentTemplate> implements CommentTemplateService {

    /**
     * 保存或更新数据
     *
     * @param param 评价模板信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateCommentTemplate(SaveUpdateCommentTemplateParam param) {
        CommentTemplate template = new CommentTemplate();
        BeanUtil.copyProperties(param, template);
        return saveOrUpdate(template);
    }

    /**
     * 分页查询
     *
     * @param param 分页查询参数
     */
    @Override
    public PageVo<CommentTemplateDto> queryCommentTemplatePage(PageCommentTemplateParam param) {
        // 查询条件构造
        LambdaQueryWrapper<CommentTemplate> wrapper = new LambdaQueryWrapper<CommentTemplate>()
                .eq(Objects.nonNull(param.getTemplateId()), CommentTemplate::getTemplateId, param.getTemplateId())
                .like(StringUtils.isNotEmpty(param.getTemplateName()), CommentTemplate::getTemplateName, param.getTemplateName())
                .like(StringUtils.isNotEmpty(param.getTemplateContent()), CommentTemplate::getTemplateContent, param.getTemplateContent())
                .eq(Objects.nonNull(param.getTemplateType()), CommentTemplate::getTemplateType, param.getTemplateType())
                .eq(Objects.nonNull(param.getTemplateStatus()), CommentTemplate::getTemplateStatus, param.getTemplateStatus())
                .like(StringUtils.isNotEmpty(param.getTemplateRemark()), CommentTemplate::getTemplateRemark, param.getTemplateRemark());
        // 分页查询
        Page<CommentTemplate> page = Page.of(param.getCurrentPage(), param.getPageSize());
        page = page(page, wrapper);
        // 转换数据
        return PageVo.<CommentTemplateDto>builder()
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .items(BeanUtil.copyToList(page.getRecords(), CommentTemplateDto.class))
                .build();
    }

    /**
     * 查询单个
     *
     * @param id 评论指标模板id
     */
    @Override
    public CommentTemplateDto queryCommentTemplateOne(Long id) {
        CommunityAssert.notNull(id, "评论指标模板id不能为空");
        CommentTemplate template = getById(id);
        return BeanUtil.copyProperties(template, CommentTemplateDto.class);
    }

    /**
     * 单个删除
     *
     * @param id 评论指标模板id
     */
    @Override
    public boolean deleteCommentTemplateOne(Long id) {
        CommunityAssert.notNull(id, "评论指标模板id不能为空");
        return removeById(id);
    }
}

