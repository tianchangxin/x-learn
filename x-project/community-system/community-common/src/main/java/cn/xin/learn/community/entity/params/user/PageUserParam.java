package cn.xin.learn.community.entity.params.user;

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
public class PageUserParam {
    //当前页
    private Integer currentPage;
    //每页显示条数
    private Integer pageSize;

    //用户ID
    private Integer userId;
    //用户名
    private String userName;
    //性别（0-保密，1-男，2-女）
    private Integer userSex;
    //邮箱
    private String email;
    //角色
    private String role;
    //部门id
    private Integer deptId;
    //是否超管（0-不是，1-是）
    private Integer superAdmin;
    //用户状态（0-禁用，1-启用）
    private Integer status;


}
