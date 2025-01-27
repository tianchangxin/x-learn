package cn.xin.learn.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("picture")
@RequiredArgsConstructor
public class PictureController {
    /**
     * 上传图片
     */
    public void uploadPicture(@RequestParam("file") String file) {
        // TODO
    }
}
