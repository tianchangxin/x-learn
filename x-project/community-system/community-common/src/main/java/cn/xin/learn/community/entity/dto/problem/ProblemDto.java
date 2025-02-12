package cn.xin.learn.community.entity.dto.problem;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title: ProblemDto
 * @Author yinan
 * @Package cn.xin.learn.community.entity.dto.problem
 * @Date 2025/1/20 16:02
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDto {
    //问题ID
    @TableId
    private Integer problemId;
    //问题名
    private String problemName;
    //问题类型
    private String problemType;
    //地点
    private String problemAddress;
    //描述
    private String problemDesc;
    //问题图片
    private String problemPic;
    //备注
    private String problemNotes;
    //问题状态（0-新增、1-指派、2-处理中、3-完成）
    private Integer problemStatus;
    //确认人Id
    private Integer confirmUserId;
    //确认人
    private String confirmUser;
    //处理人Id
    private Integer dealUserId;
    //处理人
    private String dealUser;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //创建用户
    private String createUser;
    //修改用户
    private String updateUser;
    //是否删除（0-未删除，1-删除）
    private Integer isDelete;
}
