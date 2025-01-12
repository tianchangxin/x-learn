package cn.xin.learn.community.entity.dto.community;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xin
 * @description: 社区DTO
 * @date 2025年01月12日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    //社区Id
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
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //创建用户
    private String createUser;
    //修改用户
    private String updateUser;
}
