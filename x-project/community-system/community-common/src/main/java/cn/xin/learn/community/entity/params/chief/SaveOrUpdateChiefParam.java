package cn.xin.learn.community.entity.params.chief;

import cn.xin.learn.community.entity.params.PageParam;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Title: SaveOrUpdateChiefParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.chief
 * @Date 2025/2/3 18:13
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrUpdateChiefParam {
    //政务Id
    private Integer chiefId;
    //政务标题
    @NotNull(message = "标题不能为空")
    private String chiefTitle;
    //政务类型
    @NotNull(message = "类型不能为空")
    private Integer chiefType;
    //政务内容
    private String chiefContent;
    //政务标题图片
    private String chiefPic;
    //是否发布（0:已发布，1：未发布）
    private Integer isPublish;
}
