package cn.xin.learn.community.checks.pic;

import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * @author xin
 * @description: 图片检查
 * @date 2025年01月27日
 */
public class PicCheck {
    /**
     * 检查文件后缀是否是图片
     */
    public static void checkPicSuffix(MultipartFile file) {
        CommunityAssert.notNull(file, "图片不能为空~");
        //获取后缀名
        String name = file.getOriginalFilename();
        CommunityAssert.notNull(name, "图片名不能为空~");
        String suffix = name.substring(name.lastIndexOf(".") + 1);
        //判断是否是图片
        List<String> picSuffix = Arrays.asList("jpg", "jpeg", "png", "gif", "bmp");
        boolean contains = picSuffix.contains(suffix);
        CommunityAssert.isTrue(contains, "上传的不是图片~");
    }
}
