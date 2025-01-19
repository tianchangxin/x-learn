package cn.xin.learn.community.entity.params;

import lombok.Data;

/**
 * @author xin
 * @description: 分页查询参数
 * @date 2024年12月29日
 */
@Data
public class PageParam {
    //当前页
    private Integer currentPage = 0;
    //每页显示条数
    private Integer pageSize = 10;
}
