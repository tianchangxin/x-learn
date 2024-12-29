package cn.xin.learn.community.service;

import cn.xin.learn.community.entity.params.user.PageUserParam;
import cn.xin.learn.community.entity.params.user.SaveUpdateUserParam;
import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.entity.vo.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 社区用户表;(CommunityUser)表服务接口
 *
 * @author makejava
 * @since 2024-12-24 15:42:22
 */
public interface CommunityUserService extends IService<CommunityUser> {
    /**
     * 新增或者修改用户
     *
     * @param params 用户信息
     * @return 是否新增或者修改成功
     */
    Boolean saveOrUpdateUser(SaveUpdateUserParam params);

    /**
     * 查询用户列表
     *
     * @param pageUserParam 分页参数
     * @return 用户列表
     */
    PageVo<CommunityUser> queryUserList(PageUserParam pageUserParam);

    /**
     * 注册用户
     *
     * @param param 用户信息
     * @return 是否注册成功
     */
    Boolean registerUser(SaveUpdateUserParam param);
}

