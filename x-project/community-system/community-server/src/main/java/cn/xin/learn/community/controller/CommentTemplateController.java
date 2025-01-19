package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.comment.CommentTemplateDto;
import cn.xin.learn.community.entity.params.comment.PageCommentTemplateParam;
import cn.xin.learn.community.entity.params.comment.SaveUpdateCommentTemplateParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.CommentTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 评价模板;(CommentTemplate)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@RestController
@RequestMapping("commentTemplate")
@RequiredArgsConstructor
public class CommentTemplateController {
    private final CommentTemplateService commentTemplateService;

    /**
     * 保存或者更新评价模板
     */
    @PostMapping("saveOrUpdateCommentTemplate")
    public Boolean saveOrUpdateCommentTemplate(@Validated @RequestBody SaveUpdateCommentTemplateParam param) {
        return commentTemplateService.saveOrUpdateCommentTemplate(param);
    }

    /**
     * 分页查询评价模板
     */
    @PostMapping("pageCommentTemplate")
    public PageVo<CommentTemplateDto> listCommentTemplate(@RequestBody PageCommentTemplateParam param) {
        return commentTemplateService.queryCommentTemplatePage(param);
    }

    /**
     * 查询单个评价模板
     */
    @GetMapping("getCommentTemplate")
    public CommentTemplateDto getCommentTemplate(@RequestParam Long id) {
        return commentTemplateService.queryCommentTemplateOne(id);
    }

    /**
     * 删除评价模板
     */
    @GetMapping("deleteCommentTemplate")
    public Boolean deleteCommentTemplate(@RequestParam Long id) {
        return commentTemplateService.deleteCommentTemplateOne(id);
    }
}

