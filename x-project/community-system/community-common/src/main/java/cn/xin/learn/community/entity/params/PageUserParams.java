package cn.xin.learn.community.entity.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 分页查询用户参数
 * @date 2024年12月28日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUserParams {
    //当前页
    private Integer currentPage;
    //每页显示条数
    private Integer pageSize;


}
