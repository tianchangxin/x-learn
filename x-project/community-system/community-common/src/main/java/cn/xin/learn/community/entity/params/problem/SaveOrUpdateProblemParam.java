package cn.xin.learn.community.entity.params.problem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Title: SaveOrUpdateProblemParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.problem
 * @Date 2025/1/20 16:08
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrUpdateProblemParam {
    //问题ID(修改时传ID)
    private Integer problemId;
    //问题名
    @NotNull(message = "问题名不能为空")
    private String problemName;
    //问题类型
    @NotNull(message = "问题类型不能为空")
    private String problemType;
    //地点
    private String problemAddress;
    //描述
    private String problemDesc;
    //问题图片
    private String problemPic;
    //备注
    private String problemNotes;
    //确认人Id
    private Integer confirmUserId;
    //确认人
    private String confirmUser;
    //问题状态（0-新增、1-指派、2-处理中、3-完成）
    private Integer problemStatus;
    //处理人Id
    @NotNull(message = "处理人不能为空")
    private Integer dealUserId;
    //处理人
    @NotNull(message = "处理人不能为空")
    private String dealUser;
    //是否删除（0-未删除，1-删除）
    private Integer isDelete;
}
