package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.ProblemDao;
import cn.xin.learn.server.entity.po.Problem;
import cn.xin.learn.server.service.ProblemService;
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

