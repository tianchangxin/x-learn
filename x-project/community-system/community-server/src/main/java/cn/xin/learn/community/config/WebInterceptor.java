package cn.xin.learn.community.config;

import cn.xin.learn.community.entity.po.CommunityUser;
import cn.xin.learn.community.exceptions.asserts.CommunityAssert;
import cn.xin.learn.community.helpers.UserHelper;
import cn.xin.learn.community.service.CommunityUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author xin
 * @description: 拦截器
 * @date 2024年12月28日
 */
@Slf4j
@Component
public class WebInterceptor implements HandlerInterceptor {
    @Resource
    private CommunityUserService communityUserService;

    //排除路径
    private static final List<String> EXCLUDE_PATHS = List.of("/communityUser/registerUser", "/communityUser/loginUser");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {

        //option请求不需要验证
        if (Objects.equals(request.getMethod(), "OPTIONS")) {
            return true;
        }
        String servletPath = request.getServletPath();
        //排除路径
        if (EXCLUDE_PATHS.contains(servletPath)) {
            return true;
        }
        if (dealUser(request, response)) {
            return false;
        }

        return true;

    }

    /**
     * 处理用户
     *
     * @param request  请求
     * @param response 响应
     * @return 是否处理成功
     * @throws IOException 异常
     */
    private boolean dealUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取header
        String UserId = request.getHeader("user-id");
        if (StringUtils.isEmpty(UserId)) {
            CommunityAssert.failPermission("用户未登录");
            return true;
        }
        CommunityUser communityUser = communityUserService.getBaseMapper().selectById(NumberUtils.toLong(UserId));
        if (Objects.isNull(communityUser)) {
            CommunityAssert.failPermission("用户不存在");
            return true;
        }
        //设置当前用户
        UserHelper.setCurrentUser(communityUser);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserHelper.removeCurrentUser();
    }
}
