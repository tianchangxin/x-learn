package cn.xin.learn.community.entity.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评价模板;(CommentTemplate)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("serial")
public class CommentTemplate extends BasePo {
    //评论指标模板id
    @TableId(type = IdType.AUTO)
    private Long templateId;
    //评论指标模板名称
    private String templateName;
    //模板内容
    private String templateContent;
    //模板类型（0-表单，1-打分）
    private Integer templateType;
    //模板状态（0-未发布，1-已发布，2-停用）
    private Integer templateStatus;
    //备注
    private String templateRemark;
}

