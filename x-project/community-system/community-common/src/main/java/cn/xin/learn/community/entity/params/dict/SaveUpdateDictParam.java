package cn.xin.learn.community.entity.params.dict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 保存或更新字典参数
 * @date 2025年01月19日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUpdateDictParam {
    /**
     * 字典id(新增时不传，更新时传)
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
