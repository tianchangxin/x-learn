package cn.xin.learn.community.entity.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 社区信息表;(Community)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Community extends BasePo {
    //社区Id
    @TableId(type = IdType.AUTO)
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

