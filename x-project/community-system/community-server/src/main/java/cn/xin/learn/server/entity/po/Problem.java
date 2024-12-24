package cn.xin.learn.server.entity.po;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 问题;(Problem)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:26
 */
@SuppressWarnings("serial")
public class Problem extends Model<Problem> {
    //问题ID
    private Integer problemId;
    //问题名
    private String problemName;
    //问题类型
    private String problemType;
    //地点
    private String problemAddress;
    //描述
    private String problemDesc;
    //问题图片
    private String problemPic;
    //备注
    private String problemNotes;
    //问题状态（0-新增、1-指派、2-处理中、3-完成）
    private Integer problemStatus;
    //确认人Id
    private Integer confirmUserId;
    //确认人
    private String confirmUser;
    //处理人Id
    private Integer dealUserId;
    //处理人
    private String dealUser;
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


    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getProblemAddress() {
        return problemAddress;
    }

    public void setProblemAddress(String problemAddress) {
        this.problemAddress = problemAddress;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getProblemPic() {
        return problemPic;
    }

    public void setProblemPic(String problemPic) {
        this.problemPic = problemPic;
    }

    public String getProblemNotes() {
        return problemNotes;
    }

    public void setProblemNotes(String problemNotes) {
        this.problemNotes = problemNotes;
    }

    public Integer getProblemStatus() {
        return problemStatus;
    }

    public void setProblemStatus(Integer problemStatus) {
        this.problemStatus = problemStatus;
    }

    public Integer getConfirmUserId() {
        return confirmUserId;
    }

    public void setConfirmUserId(Integer confirmUserId) {
        this.confirmUserId = confirmUserId;
    }

    public String getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser;
    }

    public Integer getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(Integer dealUserId) {
        this.dealUserId = dealUserId;
    }

    public String getDealUser() {
        return dealUser;
    }

    public void setDealUser(String dealUser) {
        this.dealUser = dealUser;
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
        return this.problemId;
    }
}

