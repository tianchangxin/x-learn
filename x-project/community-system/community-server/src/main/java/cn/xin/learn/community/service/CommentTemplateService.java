package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.comment.CommentTemplateDto;
import cn.xin.learn.community.entity.params.comment.PageCommentTemplateParam;
import cn.xin.learn.community.entity.params.comment.SaveUpdateCommentTemplateParam;
import cn.xin.learn.community.entity.po.CommentTemplate;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 评价模板;(CommentTemplate)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
public interface CommentTemplateService extends IService<CommentTemplate> {
    /**
     * 保存或更新数据
     */
    boolean saveOrUpdateCommentTemplate(SaveUpdateCommentTemplateParam param);

    /**
     * 分页查询
     */
    PageVo<CommentTemplateDto> queryCommentTemplatePage(PageCommentTemplateParam param);

    /**
     * 查询单个
     */
    CommentTemplateDto queryCommentTemplateOne(Long id);

    /**
     * 单个删除
     */
    boolean deleteCommentTemplateOne(Long id);
}

