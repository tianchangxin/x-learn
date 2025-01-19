package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

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
}
