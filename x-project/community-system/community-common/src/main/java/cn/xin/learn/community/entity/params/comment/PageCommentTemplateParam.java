package cn.xin.learn.community.entity.params.comment;

import cn.xin.learn.community.entity.params.PageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xin
 * @description: 评论模板列表查询
 * @date 2025年01月12日
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCommentTemplateParam extends PageParam {
    //评论指标模板id
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

    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //创建用户
    private String createUser;
    //修改用户
    private String updateUser;
    //是否删除（0-未删除，1-删除）
    private Integer isDelete;
}
