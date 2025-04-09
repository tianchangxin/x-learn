package cn.xin.learn.community.entity.params.user;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xin
 * @description: 保存或者更新用户参数
 * @date 2024年12月29日
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveUpdateUserParam {
    //用户ID（新增时不传，修改时传）
    private Long userId;
    //用户名
    private String userName;
    //密码
    private String pwd;
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
