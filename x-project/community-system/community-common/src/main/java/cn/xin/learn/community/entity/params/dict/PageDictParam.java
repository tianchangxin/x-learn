package cn.xin.learn.community.entity.params.dict;

import cn.xin.learn.community.entity.params.PageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 分页查询字典参数
 * @date 2025年01月19日
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDictParam extends PageParam {
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
