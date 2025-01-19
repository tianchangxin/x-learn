package cn.xin.learn.community.entity.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 社区用户表;(CommunityUser)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("serial")
public class CommunityUser extends BasePo {
    //用户ID
    @TableId(type = IdType.AUTO)
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

