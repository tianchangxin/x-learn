package cn.xin.learn.server.entity.po;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 评价模板;(CommentTemplate)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@SuppressWarnings("serial")
public class CommentTemplate extends Model<CommentTemplate> {
    //评论指标模板id
    private Integer templateId;
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
    private Integer delete;


    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public Integer getTemplateStatus() {
        return templateStatus;
    }

    public void setTemplateStatus(Integer templateStatus) {
        this.templateStatus = templateStatus;
    }

    public String getTemplateRemark() {
        return templateRemark;
    }

    public void setTemplateRemark(String templateRemark) {
        this.templateRemark = templateRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.templateId;
    }
}

