package com.yhb.interceptor;

import com.yhb.dao.UserMapper;
import com.yhb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YangHaiBo
 * @create 2019-09-29 16:24
 */
public class AdminInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //对访问管理员请求是否有管理员权限进行拦截
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    //通过token查询出用户
                    User user = userMapper.searchUserByToken(cookie.getValue());
                    if (user != null) {
                        //存在用户,检验用户是否为管理员
                        if (user.isAdmin()) {
                            return true;
                        } else {
                            response.sendRedirect("/404");
                            return false;
                        }
                    }
                    break;
                }
            }
        }
        response.sendRedirect("/404");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //nothing to do
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //nothing to do
    }
}
