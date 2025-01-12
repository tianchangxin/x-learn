package cn.xin.learn.community.entity.params.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author xin
 * @description: 保存更新评论模板参数
 * @date 2025年01月12日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUpdateCommentTemplateParam {
    //评论指标模板id
    private Long templateId;
    //评论指标模板名称
    private String templateName;
    //模板内容
    private String templateContent;
    //模板类型（0-表单，1-打分）
    @NotNull(message = "模板类型不能为空")
    private Integer templateType;
    //模板状态（0-未发布，1-已发布，2-停用）
    @NotNull(message = "模板状态不能为空")
    private Integer templateStatus;
    //备注
    private String templateRemark;
}
