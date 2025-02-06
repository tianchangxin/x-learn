package cn.xin.learn.community.feign;

import feign.Headers;
import feign.RequestLine;

import java.io.File;

/**
 * @author xin
 * @description: smms feign
 * @date 2025年01月27日
 */
public interface SmmsFeign {
    @RequestLine("GET /permissions/listUser")
    @Headers({"user-id: 1"})
    Object myfeign();

    @RequestLine("POST /api/v2/upload")
    @Headers({"Authorization: NBvVpjtoMFXzgKJcblGnES5u21hxrfQ4"
            , "Content-Type: multipart/form-data"})
    Object uploadImage(File smfile);
}
