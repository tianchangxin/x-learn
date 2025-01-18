package cn.xin.learn.community.entity.params.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;

/**
 * @author xin
 * @description: 登录用户参数
 * @date 2024年12月29日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class LoginUserParam {
    //用户名
    private String userName;
    //邮箱
    private String email;
    //密码
    @NotEmpty(message = "密码不能为空")
    private String pwd;
}
