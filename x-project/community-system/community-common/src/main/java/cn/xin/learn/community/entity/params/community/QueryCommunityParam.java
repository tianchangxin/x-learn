package cn.xin.learn.community.entity.params.community;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 查询社区参数
 * @date 2025年01月12日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryCommunityParam {
    //社区Id(一个社区的话，不用传）
    private Long communityId;
}
