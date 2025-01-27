package cn.xin.learn.community.feign.support;

import cn.hutool.json.JSONUtil;
import cn.xin.learn.community.checks.pic.PicCheck;
import cn.xin.learn.community.feign.SmmsFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xin
 * @description: 图片上传服务支撑
 * @date 2025年01月27日
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SmmsSupport {
    private final SmmsFeign smmsFeign;

    /**
     * 根据图片文件上传并生成url
     */
    public String uploadImage(MultipartFile imageFile) {
        PicCheck.checkPicSuffix(imageFile);
        // 主图的项目路径
        String paFileName = imageFile.getOriginalFilename();
        FileOutputStream stream = null;
        File file = null;
        try {
            byte[] bytes = imageFile.getBytes();
            //自定义文件名
            String filename = UUID.randomUUID().toString().replace("-", "");
            file = new File(filename + paFileName);
            if (!file.exists()) {
                //创建文件
                file.createNewFile();
                stream = new FileOutputStream(file.getAbsoluteFile());
                stream.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //上传图片
        try {
            smmsFeign.uploadImage(file);
        } catch (Exception e) {
            log.error("上传图片失败", e);
        }
        Object image = smmsFeign.uploadImage(file);
        String jsonStr = JSONUtil.toJsonStr(image);
        System.out.println("jsonStr = " + jsonStr);

        return null;
    }

}
