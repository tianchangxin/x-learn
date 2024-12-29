package cn.xin.learn.community.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xin
 * @description: 异常响应实体
 * @date 2024年12月29日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Response {
    //状态码
    private Integer code;
    //标题
    private String title;
    //消息
    private String message;
    //具体异常内容
    private Object data;
    //url
    private String url;
}
