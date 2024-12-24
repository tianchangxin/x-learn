package cn.xin.learn.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xin.learn.server.dao.CommentTemplateDao;
import cn.xin.learn.server.entity.po.CommentTemplate;
import cn.xin.learn.server.service.CommentTemplateService;
import org.springframework.stereotype.Service;

/**
 * 评价模板;(CommentTemplate)表服务实现类
 *
 * @author makejava
 * @since 2024-12-24 15:42:23
 */
@Service("commentTemplateService")
public class CommentTemplateServiceImpl extends ServiceImpl<CommentTemplateDao, CommentTemplate> implements CommentTemplateService {

}

