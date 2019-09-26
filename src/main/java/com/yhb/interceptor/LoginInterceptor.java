package com.yhb.interceptor;

import com.yhb.dao.UserMapper;
import com.yhb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YangHaiBo
 * @create 2019-09-25 15:58
 */
@Service
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录前拦截
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    //获得cookie里面的内容
                    String token = cookie.getValue();
                    //通过token查询出用户
                    User user = userMapper.searchUserByToken(token);
                    if (user != null) {
                        //存在用户,将用户信息发送到前端session
                        request.getSession().setAttribute("user", user);
                        //重新激活cookie存活时间
                        cookie.setMaxAge(0);
                        Cookie cookie_new = new Cookie("token", token);
                        cookie_new.setMaxAge(3600);
                        return true;
                    }
                    break;
                }
            }
        }
        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
