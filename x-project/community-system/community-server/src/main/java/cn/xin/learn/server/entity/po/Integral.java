package cn.xin.learn.server.entity.po;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 积分;(Integral)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:25
 */
@SuppressWarnings("serial")
public class Integral extends Model<Integral> {
    //积分ID
    private Integer integralId;
    //积分来源
    private String integralOrigin;
    //积分数量
    private Double integralNum;
    //归属用户
    private String belongUser;
    //归属用户Id
    private Integer belongUserId;
    //积分类型（0-使用、1-新增）
    private Double integralType;
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


    public Integer getIntegralId() {
        return integralId;
    }

    public void setIntegralId(Integer integralId) {
        this.integralId = integralId;
    }

    public String getIntegralOrigin() {
        return integralOrigin;
    }

    public void setIntegralOrigin(String integralOrigin) {
        this.integralOrigin = integralOrigin;
    }

    public Double getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(Double integralNum) {
        this.integralNum = integralNum;
    }

    public String getBelongUser() {
        return belongUser;
    }

    public void setBelongUser(String belongUser) {
        this.belongUser = belongUser;
    }

    public Integer getBelongUserId() {
        return belongUserId;
    }

    public void setBelongUserId(Integer belongUserId) {
        this.belongUserId = belongUserId;
    }

    public Double getIntegralType() {
        return integralType;
    }

    public void setIntegralType(Double integralType) {
        this.integralType = integralType;
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
        return this.integralId;
    }
}

