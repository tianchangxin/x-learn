package cn.xin.learn.community.controller;

import cn.xin.learn.community.entity.dto.usercomment.UserCommentTemplateDto;
import cn.xin.learn.community.entity.params.task.QueryTaskParam;
import cn.xin.learn.community.entity.params.usercomment.SaveOrUpdateUserCommentParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.UserCommentTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户任务评价信息管理
 * @Title: UserCommentTemplateController
 * @Author yinan
 * @Package cn.xin.learn.community.controller
 * @Date 2025/2/12 9:58
 * @description:
 */
@RestController
@RequestMapping("userCommentTemplate")
public class UserCommentTemplateController {


    @Autowired
    private UserCommentTemplateService userCommentTemplateService;


    /**
     * 查询某个任务(根据id或者任务名)的评价信息
     * @param queryTaskParam 查询参数
     * @return 用户评价信息
     */
    @RequestMapping("queryTaskCommentInfo")
    public PageVo<UserCommentTemplateDto> queryTaskCommentInfo(@RequestBody QueryTaskParam queryTaskParam){
        return userCommentTemplateService.queryTaskCommentInfo(queryTaskParam);
    }


    /**
     * 添加或修改某个活动的评价信息
     * @param userCommentParam 评价信息
     * @return  是否添加成功
     */
    @RequestMapping("saveOrUpdateTaskComment")
    public Boolean saveOrUpdateTaskComment(@RequestBody SaveOrUpdateUserCommentParam userCommentParam){
        return userCommentTemplateService.saveOrUpdateTaskCommentInfo(userCommentParam);
    }


    /**
     * 删除某个用户的的评价信息
     * @param userTemplateId
     * @return
     */
    @RequestMapping("deleteTaskComment")
    public Boolean deleteTaskComment(Integer userTemplateId){
        return userCommentTemplateService.deleteTaskCommentInfo(userTemplateId);
    }

}
