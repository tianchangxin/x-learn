package cn.xin.learn.community.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xin
 * @description: 社区异常
 * @date 2024年12月28日
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Slf4j
public class CommunityException extends RuntimeException {
    public CommunityException(String message) {
        super(message);
    }

    public CommunityException(String message, Throwable cause) {
        super(message, cause);
    }


}
