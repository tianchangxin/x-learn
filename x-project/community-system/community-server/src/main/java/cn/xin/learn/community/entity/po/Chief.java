package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 政务表;(Chief)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@Data
public class Chief extends Model<Chief> {
    //政务Id
    @TableId
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

}

