package cn.xin.learn.community.web;

import cn.xin.learn.community.exceptions.CommunityException;
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

    @ExceptionHandler(value = CommunityException.class)
    @ResponseBody
    public Response handleCommunityException(CommunityException e, HttpServletRequest request) {
        log.error("社区异常：{}", e.getMessage());
        return Response.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title(e.getMessage())
                .message(e.getMessage())
                .data(e.toString())
                .url(request.getRequestURI())
                .build();
    }
}
