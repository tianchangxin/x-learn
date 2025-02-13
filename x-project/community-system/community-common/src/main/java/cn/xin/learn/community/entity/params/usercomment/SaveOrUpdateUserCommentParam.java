package cn.xin.learn.community.entity.params.usercomment;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Title: SaveOrUpdateUserCommentParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.usercomment
 * @Date 2025/2/10 14:05
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrUpdateUserCommentParam {
    /**
     * 用户-模板id
     */
    private Long userTemplateId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 模板id
     */
    @NotNull(message = "模板id不能为空")
    private Long templateId;

    /**
     * 模板内容
     */
    @NotNull(message = "模板内容不能为空")
    private String templateContent;

    /**
     * 模板备注
     */
    private String templateRemark;

    /**
     * 任务Id
     */
    @NotNull(message = "任务Id不能为空")
    private Long taskId;
}
