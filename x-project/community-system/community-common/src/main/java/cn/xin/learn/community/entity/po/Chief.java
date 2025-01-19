package cn.xin.learn.community.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 政务表;(Chief)表实体类
 *
 * @author makejava
 * @since 2024-12-24 15:42:24
 */
@Data
@TableName(value = "chief")
public class Chief extends BasePo {
    //政务Id
    @TableId
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

