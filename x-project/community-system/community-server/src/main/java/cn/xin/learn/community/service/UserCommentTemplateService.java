package cn.xin.learn.community.service;

/**
 * @author xin
 * @description: TODO
 * @date 2025年02月05日
 */

import cn.xin.learn.community.entity.dto.usercomment.UserCommentTemplateDto;
import cn.xin.learn.community.entity.params.task.QueryTaskParam;
import cn.xin.learn.community.entity.params.usercomment.SaveOrUpdateUserCommentParam;
import cn.xin.learn.community.entity.po.UserCommentTemplate;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户评论;(user_comment_template)表服务接口
 */
public interface UserCommentTemplateService extends IService<UserCommentTemplate> {
    // 查询某个已经完成的任务的评价信息
    PageVo<UserCommentTemplateDto> queryTaskCommentInfo(QueryTaskParam taskParam);

    // 添加评价信息
    Boolean saveOrUpdateTaskCommentInfo(SaveOrUpdateUserCommentParam saveOrUpdateUserCommentParam);

    Boolean deleteTaskCommentInfo(Integer taskId);
}