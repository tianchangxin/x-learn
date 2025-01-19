package cn.xin.learn.community.entity.dto.dict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 表单信息
 * @date 2025年01月19日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictDto {
    /**
     * 字典id
     */
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
