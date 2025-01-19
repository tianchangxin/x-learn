package cn.xin.learn.community.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xin
 * @description: 分页Vo
 * @date 2024年12月28日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class PageVo<T> {
    //总页数
    private Long totalPage = 0L;
    //总条数
    private Long totalElement = 0L;
    //数据
    private List<T> items = new ArrayList<>();
}
