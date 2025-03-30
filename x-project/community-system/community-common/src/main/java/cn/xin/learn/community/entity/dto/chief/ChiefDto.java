package cn.xin.learn.community.entity.dto.chief;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: ChiefDto
 * @Author yinan
 * @Package cn.xin.learn.community.entity.dto.chief
 * @Date 2025/2/3 18:11
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiefDto {
    //政务Id
    private Integer chiefId;
    //政务标题
    private String chiefTitle;
    //政务类型
    private Integer chiefType;
    //政务内容
    private String chiefContent;
    //政务标题图片
    private String chiefPic;
}
