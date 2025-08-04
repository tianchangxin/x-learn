package cn.xin.learn.community.entity.params.chief;

import cn.xin.learn.community.entity.params.PageParam;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: QueryChiefParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.chief
 * @Date 2025/2/3 18:12
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryChiefParam extends PageParam {
    //政务标题
    private String chiefTitle;
    //政务类型
    private Integer chiefType;
    //政务内容
    private String chiefContent;
    //是否发布（0:已发布，1：未发布）
    private Integer isPublish;
}
