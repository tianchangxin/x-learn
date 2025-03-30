package cn.xin.learn.community.entity.dto.usercomment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: UserCommentTemplateDto
 * @Author yinan
 * @Package cn.xin.learn.community.entity.dto.usercomment
 * @Date 2025/2/7 23:07
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommentTemplateDto {
    /**
     * 用户-模板id
     */
    private Long userTemplateId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 模板id
     */
    private Long templateId;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 模板内容
     */
    private String templateContent;
}
