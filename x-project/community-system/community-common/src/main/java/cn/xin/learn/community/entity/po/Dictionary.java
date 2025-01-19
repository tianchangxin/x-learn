package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author xin
 * @description: 字典表实体
 * @date 2025年01月19日
 */
@Data
public class Dictionary extends BasePo {
    /**
     * 字典id
     */
    @TableId(type = IdType.AUTO)
    private Long dictId;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 字典编码
     */
    private String dictCode;
    /**
     * 状态：0-禁用，1-启用
     */
    private Integer dictStatus;
    /**
     * 字典备注
     */
    private String dictRemark;
    /**
     * 字典项
     */
    private String dictItem;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建用户
     */
    private String createUser;
    /**
     * 修改用户
     */
    private String updateUser;
    /**
     * 是否删除（0-未删除，1-删除）
     */
    private Integer isDelete;
}
