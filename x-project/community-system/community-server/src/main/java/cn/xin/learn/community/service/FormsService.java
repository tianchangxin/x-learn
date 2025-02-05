package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.dto.forms.FormsDto;
import cn.xin.learn.community.entity.params.forms.PageFormsParam;
import cn.xin.learn.community.entity.params.forms.QueryFormsParam;
import cn.xin.learn.community.entity.params.forms.SaveUpdateFormsParam;
import cn.xin.learn.community.entity.po.Forms;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author tiancx
 * @description 针对表【forms(;)】的数据库操作Service
 * @createDate 2025-01-19 20:31:34
 */
public interface FormsService extends IService<Forms> {

    /**
     * 新增或修改表单
     *
     * @param param 表单信息
     * @return 是否新增或修改成功
     */
    Boolean saveOrUpdateForms(SaveUpdateFormsParam param);

    /**
     * 删除表单
     *
     * @param formsId 表单ID
     * @return 是否删除成功
     */
    Boolean deleteForms(Long formsId);

    /**
     * 分页查询表单列表
     *
     * @param pageFormsParam 分页参数
     * @return 表单列表
     */
    PageVo<FormsDto> queryFormsPage(PageFormsParam pageFormsParam);

    /**
     * 查询表单列表
     *
     * @param param 查询参数
     * @return 表单列表
     */
    List<FormsDto> queryFormsList(QueryFormsParam param);

    /**
     * 查询表单详情
     *
     * @param formsId 表单ID
     * @return 表单详情
     */
    FormsDto queryFormsDetail(Long formsId);
}
