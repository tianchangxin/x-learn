package cn.xin.learn.server.entity.po;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 政务表;(Chief)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@SuppressWarnings("serial")
public class Chief extends Model<Chief> {
    //政务Id
    private Integer chiefId;
    //政务标题
    private String chiefTitle;
    //政务类型
    private Integer chiefType;
    //政务内容
    private String chiefContent;
    //政务标题图片
    private String chiefPic;
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


    public Integer getChiefId() {
        return chiefId;
    }

    public void setChiefId(Integer chiefId) {
        this.chiefId = chiefId;
    }

    public String getChiefTitle() {
        return chiefTitle;
    }

    public void setChiefTitle(String chiefTitle) {
        this.chiefTitle = chiefTitle;
    }

    public Integer getChiefType() {
        return chiefType;
    }

    public void setChiefType(Integer chiefType) {
        this.chiefType = chiefType;
    }

    public String getChiefContent() {
        return chiefContent;
    }

    public void setChiefContent(String chiefContent) {
        this.chiefContent = chiefContent;
    }

    public String getChiefPic() {
        return chiefPic;
    }

    public void setChiefPic(String chiefPic) {
        this.chiefPic = chiefPic;
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
        return this.chiefId;
    }
}

