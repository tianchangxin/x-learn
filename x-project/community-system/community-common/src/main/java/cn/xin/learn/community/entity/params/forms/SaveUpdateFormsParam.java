package cn.xin.learn.community.entity.params.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 保存或更新表单项参数
 * @date 2025年02月05日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUpdateFormsParam {
    /**
     * 表单项id 【新增时不传，更新时传】
     */
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
