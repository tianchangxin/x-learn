package cn.xin.learn.community.entity.params.problem;

import cn.xin.learn.community.entity.params.PageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: QueryProblemParam
 * @Author yinan
 * @Package cn.xin.learn.community.entity.params.problem
 * @Date 2025/1/20 16:01
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryProblemParam extends PageParam {
    //问题ID
    private Integer problemId;
    //问题名
    private String problemName;
    //问题类型
    private String problemType;
    //问题状态（0-新增、1-指派、2-处理中、3-完成）
    private Integer problemStatus;
    //处理人Id
    private Integer dealUserId;
    //是否删除（0-未删除，1-删除）
    private Integer isDelete;
}
