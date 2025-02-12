package cn.xin.learn.community.controller;


import cn.xin.learn.community.entity.dto.problem.ProblemDto;
import cn.xin.learn.community.entity.params.problem.QueryProblemParam;
import cn.xin.learn.community.entity.params.problem.SaveOrUpdateProblemParam;
import cn.xin.learn.community.entity.vo.PageVo;
import cn.xin.learn.community.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 问题;(Problem)表控制层
 *
 * @author makejava
 * @since 2024-12-24 15:42:26
 */
@RestController
@RequestMapping("problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;


    @RequestMapping("listProblem")
    public PageVo<ProblemDto> listProblem(@RequestBody QueryProblemParam problemParam) {
        return problemService.queryProblemList(problemParam);
    }


    /**
     * 保存或更新问题
     * @param problem 问题参数
     * @return 保存或更新是否成功
     */
    @RequestMapping("saveOrUpdateProblem")
    public Boolean saveOrUpdateProblem(@RequestBody SaveOrUpdateProblemParam problem) {
        return problemService.saveOrUpdateProblem(problem);
    }

    /**
     * 删除问题
     * @param problemId 问题id
     * @return 删除是否成功
     */
    @RequestMapping("deleteProblem")
    public Boolean deleteProblem(Integer problemId) {
        return problemService.deleteProblem(problemId);
    }

}

