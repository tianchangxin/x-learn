package cn.xin.learn.community.entity.params.permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xin
 * @description: 查询权限参数
 * @date 2024年12月29日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryPermissionParam {
    //用户Id
    private Long userId;
    //页面名称
    private String pageName;
    //权限类型（增删改查）
    private String type;
}
