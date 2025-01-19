package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 问题;(Problem)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:26
 */
@SuppressWarnings("serial")
public class Problem extends BasePo {
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

}

