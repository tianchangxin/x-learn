package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @author xin
 * @description: 基础实体类
 * @date 2024年12月28日
 */
@Data
public class BasePo {
    //创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //创建用户
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    //修改用户
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;

    //是否删除（0-未删除，1-删除）
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;
}
