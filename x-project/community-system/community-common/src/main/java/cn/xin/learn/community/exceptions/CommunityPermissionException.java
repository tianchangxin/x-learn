package cn.xin.learn.community.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * @author xin
 * @description: 社区权限异常
 * @date 2024年12月29日
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Slf4j
public class CommunityPermissionException extends CommunityException {
    //权限异常状态码
    public static Integer CODE = HttpStatus.FORBIDDEN.value();

    public CommunityPermissionException(String message) {
        super(message);
    }

    public CommunityPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

}
