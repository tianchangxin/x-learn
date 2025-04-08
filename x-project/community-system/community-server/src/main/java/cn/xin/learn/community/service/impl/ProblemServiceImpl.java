package cn.xin.learn.community.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.dao.ProblemDao;
import cn.xin.learn.community.entity.dto.problem.ProblemDto;
import cn.xin.learn.community.entity.params.problem.QueryProblemParam;
import cn.xin.learn.community.entity.params.problem.SaveOrUpdateProblemParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.po.Problem;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.helpers.UserHelper;
import cn.xin.learn.community.service.ProblemService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 问题;(Problem)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@Service("problemService")
public class ProblemServiceImpl extends ServiceImpl<ProblemDao, Problem> implements ProblemService {


    @Override
    public PageVo<ProblemDto> queryProblemList(QueryProblemParam problemParam) {
        LambdaQueryWrapper<Problem> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Objects.nonNull(problemParam.getProblemName()), Problem::getProblemName, problemParam.getProblemName())
                .eq(Objects.nonNull(problemParam.getProblemType()), Problem::getProblemType, problemParam.getProblemType())
                .eq(Objects.nonNull(problemParam.getProblemStatus()), Problem::getProblemStatus, problemParam.getProblemStatus())
                .eq(Objects.nonNull(problemParam.getDealUserId()), Problem::getDealUserId, problemParam.getDealUserId())
                .eq(Objects.nonNull(problemParam.getCreateUser()),Problem::getCreateUser,problemParam.getCreateUser())
                .eq(Objects.nonNull(problemParam.getIsDelete()), Problem::getIsDelete, problemParam.getIsDelete())
                .orderByDesc(Problem::getProblemId);
        Page<Problem> page = Page.of(problemParam.getCurrentPage(), problemParam.getPageSize());
        page = this.page(page, wrapper);
        return PageVo.<ProblemDto>builder()
                .items(BeanUtil.copyToList(page.getRecords(), ProblemDto.class))
                .totalElement(page.getTotal())
                .totalPage(page.getPages())
                .build();
    }

    @Override
    public Boolean saveOrUpdateProblem(SaveOrUpdateProblemParam problem) {
        CommunityUser currentUser = UserHelper.getCurrentUser();
        Problem problemPo = BeanUtil.copyProperties(problem, Problem.class);
        problemPo.setConfirmUserId(Math.toIntExact(currentUser.getUserId()));
        problemPo.setConfirmUser(currentUser.getUserName());
        return saveOrUpdate(problemPo);
    }

    @Override
    public Boolean deleteProblem(Integer problemId) {
        return removeById(problemId);
    }
}

