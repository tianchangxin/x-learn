package cn.xin.learn.community.service.impl;

import cn.xin.learn.community.dao.ProblemDao;
import cn.xin.learn.community.entity.po.Problem;
import cn.xin.learn.community.service.ProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 问题;(Problem)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:27
 */
@Service("problemService")
public class ProblemServiceImpl extends ServiceImpl<ProblemDao, Problem> implements ProblemService {

}

