package cn.xin.learn.community.entity.params.dict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 删除字典参数
 * @date 2025年01月19日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDictParam {
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


}
