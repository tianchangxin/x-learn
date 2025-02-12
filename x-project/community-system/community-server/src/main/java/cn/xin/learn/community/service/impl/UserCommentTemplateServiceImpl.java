package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.UserCommentTemplateDao;
import cn.xin.learn.community.entity.dto.usercomment.UserCommentTemplateDto;
import cn.xin.learn.community.entity.params.task.QueryTaskParam;
import cn.xin.learn.community.entity.params.usercomment.SaveOrUpdateUserCommentParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.po.UserCommentTemplate;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.helpers.UserHelper;
import cn.xin.learn.community.service.UserCommentTemplateService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author xin
 * @description: 用户评论;(user_comment_template)表服务实现类
 * @date 2025年02月05日
 */
@Service
public class UserCommentTemplateServiceImpl extends ServiceImpl<UserCommentTemplateDao, UserCommentTemplate> implements UserCommentTemplateService {




    @Override
    public PageVo<UserCommentTemplateDto> queryTaskCommentInfo(QueryTaskParam taskParam){
        LambdaQueryWrapper<UserCommentTemplate> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Objects.nonNull(taskParam.getTaskId()),UserCommentTemplate::getTaskId,taskParam.getTaskId())
                .like(Objects.nonNull(taskParam.getTaskName()),UserCommentTemplate::getTemplateName,taskParam.getTaskName())
                .eq(UserCommentTemplate::getIsDelete,0)
                .orderByDesc(UserCommentTemplate::getUserTemplateId);
        Page<UserCommentTemplate> page = Page.of(taskParam.getCurrentPage(), taskParam.getPageSize());
        page = this.page(page, wrapper);
        List<UserCommentTemplate> userCommentTemplates = page.getRecords();
        List<UserCommentTemplateDto> userCommentTemplateDtos = Optional.ofNullable(userCommentTemplates)
                .orElse(new ArrayList<>())
                .stream()
                .map(userCommentTemplate -> {
                    UserCommentTemplateDto userCommentTemplateDto = new UserCommentTemplateDto();
                    BeanUtil.copyProperties(userCommentTemplate,userCommentTemplateDto);
                    userCommentTemplateDto.setTemplateContent(userCommentTemplate.getTemplateContent());
                    return userCommentTemplateDto;
                })
                .collect(Collectors.toList());
        return PageVo.<UserCommentTemplateDto>builder()
                .items(userCommentTemplateDtos)
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .build();
    }



    // 添加评价信息
    @Override
    public Boolean saveOrUpdateTaskCommentInfo(SaveOrUpdateUserCommentParam saveOrUpdateUserCommentParam){
        CommunityUser currentUser = UserHelper.getCurrentUser();
        UserCommentTemplate userCommentTemplate = new UserCommentTemplate();
        BeanUtil.copyProperties(saveOrUpdateUserCommentParam,userCommentTemplate);
        userCommentTemplate.setUserId(currentUser.getUserId());
        userCommentTemplate.setTemplateContent(JSONObject.toJSONString(saveOrUpdateUserCommentParam.getTemplateContent()));
        return this.saveOrUpdate(userCommentTemplate);
    }

    @Override
    public Boolean deleteTaskCommentInfo(Integer userCommentTemplateId){
        LambdaQueryWrapper<UserCommentTemplate> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserCommentTemplate::getUserTemplateId,userCommentTemplateId);
        return  baseMapper.delete(wrapper)>0;
    }
}
