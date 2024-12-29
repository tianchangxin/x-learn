package cn.xin.learn.community.web;

import cn.xin.learn.community.exceptions.CommunityException;
import cn.xin.learn.community.exceptions.CommunityPermissionException;
import cn.xin.learn.community.web.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xin
 * @description: 全局异常处理
 * @date 2024年12月29日
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 服务异常
     *
     * @param e       异常
     * @param request 请求
     * @return 响应
     */
    @ExceptionHandler(value = CommunityException.class)
    @ResponseBody
    public Response handleCommunityException(CommunityException e, HttpServletRequest request) {
        log.error("社区异常：{}", e.getMessage());
        return Response.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title("社区系统服务异常，请联系管理员")
                .message(e.getMessage())
                .data(e.getLocalizedMessage())
                .url(request.getRequestURI())
                .build();
    }

    /**
     * 权限异常
     */
    @ExceptionHandler(value = CommunityPermissionException.class)
    @ResponseBody
    public Response handleCommunityPermissionException(CommunityPermissionException e, HttpServletRequest request) {
        log.error("社区权限异常：{}", e.getMessage());
        return Response.builder()
                .code(CommunityPermissionException.CODE)
                .title("社区系统权限异常，请联系管理员")
                .message(e.getMessage())
                .data(e.getLocalizedMessage())
                .url(request.getRequestURI())
                .build();
    }

}
