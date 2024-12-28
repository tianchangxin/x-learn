package cn.xin.learn.community.entity.po;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 社区信息表;(Community)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@Data
@SuppressWarnings("serial")
public class Community extends BasePo {
    //社区Id
    @TableId
    private Integer communityId;
    //社区名
    private String communityName;
    //社区负责人
    private String communityHeader;
    //社区负责人Id
    private Integer communityHeaderId;
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
    //是否删除（0-未删除，1-删除）
    private Integer delete;

}

