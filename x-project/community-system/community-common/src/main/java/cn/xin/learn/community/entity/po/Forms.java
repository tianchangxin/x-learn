package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author xin
 * @description: 表单 表格
 * @date 2025年01月19日
 */
@Data
public class Forms extends BasePo {
    /**
     * 表单项id
     */
    @TableId(type = IdType.AUTO)
    private Long formsId;
    /**
     * 表单项标题
     */
    private String formsTitle;
    /**
     * 表单项类型
     */
    private String formsType;
    /**
     * 是否必填 0-否，1-是
     */
    private Integer formsMustFill;
    /**
     * 字典id
     */
    private Long dictId;
    /**
     * 表单状态 0-禁用，1-启用
     */
    private Integer formsStatus;
    /**
     * 表单备注
     */
    private String formsRemark;

}
