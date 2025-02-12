package cn.xin.learn.community.service;

import cn.hutool.core.bean.BeanUtil;
import cn.xin.learn.community.entity.dto.problem.ProblemDto;
import cn.xin.learn.community.entity.params.problem.QueryProblemParam;
import cn.xin.learn.community.entity.params.problem.SaveOrUpdateProblemParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.po.Problem;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.helpers.UserHelper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 问题;(Problem)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:26
 */
public interface ProblemService extends IService<Problem> {

    PageVo<ProblemDto> queryProblemList(QueryProblemParam problemParam);


    Boolean saveOrUpdateProblem(SaveOrUpdateProblemParam problem);

    Boolean deleteProblem(Integer problemId);
}

