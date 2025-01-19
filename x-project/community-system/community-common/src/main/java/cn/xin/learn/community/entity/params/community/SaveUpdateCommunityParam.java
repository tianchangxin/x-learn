package cn.xin.learn.community.entity.params.community;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 保存更新社区参数
 * @date 2024年12月29日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUpdateCommunityParam {
    //社区Id(新增时不传，修改时传)
    private Long communityId;
    //社区名
    private String communityName;
    //社区负责人
    private String communityHeader;
    //社区负责人Id
    private Long communityHeaderId;
    //社区描述
    private String communityDescribe;
    //社区人数
    private Integer communityUser;
}
