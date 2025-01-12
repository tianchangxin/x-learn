package cn.xin.learn.community.comment;

import cn.xin.learn.community.entity.dto.comment.CommentTemplateDto;
import cn.xin.learn.community.entity.params.comment.PageCommentTemplateParam;
import cn.xin.learn.community.entity.params.comment.SaveUpdateCommentTemplateParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.CommentTemplateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author xin
 * @description: 评论模板测试
 * @date 2025年01月12日
 */
@SpringBootTest
public class CommentTest {
    @Resource
    private CommentTemplateService commentTemplateService;

    /**
     * test intsert
     */
    @Test
    public void testInsert() {
        SaveUpdateCommentTemplateParam param = new SaveUpdateCommentTemplateParam();
        param.setTemplateContent("test");
        param.setTemplateContent("测试模板");
        param.setTemplateType(0);
        param.setTemplateStatus(1);
        boolean b = commentTemplateService.saveOrUpdateCommentTemplate(param);
        Assertions.assertTrue(b);
    }

    /**
     * test update , 测试后还原
     */
    @Test
    public void testUpdate() {
        SaveUpdateCommentTemplateParam param = new SaveUpdateCommentTemplateParam();
        param.setTemplateId(1L);
        param.setTemplateName("test");
        param.setTemplateContent("测试模板-修改");
        param.setTemplateType(0);
        param.setTemplateStatus(1);
        boolean b = commentTemplateService.saveOrUpdateCommentTemplate(param);
        Assertions.assertTrue(b);
        //查询单个
        CommentTemplateDto templateDto = commentTemplateService.queryCommentTemplateOne(1L);
        Assertions.assertEquals("测试模板-修改", templateDto.getTemplateContent());
        //还原
        param.setTemplateContent("测试模板");
        boolean b1 = commentTemplateService.saveOrUpdateCommentTemplate(param);
        Assertions.assertTrue(b1);
        //验证还原
        CommentTemplateDto templateDto1 = commentTemplateService.queryCommentTemplateOne(1L);
        Assertions.assertEquals("测试模板", templateDto1.getTemplateContent());
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testPage() {
        //查询
        PageCommentTemplateParam param = new PageCommentTemplateParam();
        param.setCurrentPage(1);
        param.setPageSize(10);
        PageVo<CommentTemplateDto> commentTemplateDtoPageVo = commentTemplateService.queryCommentTemplatePage(param);
        Assertions.assertNotNull(commentTemplateDtoPageVo);
        Assertions.assertTrue(commentTemplateDtoPageVo.getTotalPage() > 0);
    }

    /**
     * test delete
     */
    @Test
    public void testDelete() {
        boolean b = commentTemplateService.deleteCommentTemplateOne(1L);
        Assertions.assertTrue(b);
    }
}
