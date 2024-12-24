package cn.xin.learn.server.entity.po;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 社区信息表;(Community)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@SuppressWarnings("serial")
public class Community extends Model<Community> {
    //社区Id
    private Integer communityId;
    //社区名
    private String communityName;
    //社区负责人
    private String communityHeader;
    //社区负责人Id
    private Integer communityHeaderId;
    //社区描述
    private String communityDescribe;
    //社区人数
    private Integer communityUser;
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


    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityHeader() {
        return communityHeader;
    }

    public void setCommunityHeader(String communityHeader) {
        this.communityHeader = communityHeader;
    }

    public Integer getCommunityHeaderId() {
        return communityHeaderId;
    }

    public void setCommunityHeaderId(Integer communityHeaderId) {
        this.communityHeaderId = communityHeaderId;
    }

    public String getCommunityDescribe() {
        return communityDescribe;
    }

    public void setCommunityDescribe(String communityDescribe) {
        this.communityDescribe = communityDescribe;
    }

    public Integer getCommunityUser() {
        return communityUser;
    }

    public void setCommunityUser(Integer communityUser) {
        this.communityUser = communityUser;
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
        return this.communityId;
    }
}

