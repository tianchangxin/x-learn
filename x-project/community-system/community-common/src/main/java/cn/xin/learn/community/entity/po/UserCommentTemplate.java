package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author xin
 * @description: 用户评论模板
 * @date 2025年02月05日
 */
@Data
public class UserCommentTemplate extends BasePo {
    /**
     * 用户-模板id
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 模板类型
     */
    private Integer templateType;

    /**
     * 模板状态
     */
    private Integer templateStatus;

    /**
     * 模板备注
     */
    private String templateRemark;

    /**
     * 任务Id
     */
    private Long taskId;

}
