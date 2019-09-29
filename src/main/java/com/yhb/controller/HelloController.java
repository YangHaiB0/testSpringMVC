package com.yhb.controller;

import com.yhb.dao.UserMapper;
import com.yhb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author YangHaiBo
 * @create 2019-09-23 12:48
 */
@Controller
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(path = "/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    //获得cookie里面的内容
                    String token = cookie.getValue();
                    //通过token查询出用户
                    User user = userMapper.searchUserByToken(token);
                    if (Boolean.TRUE.equals(user.isAdmin())) {
                        return "redirect:/adminUser";
                    } else {
                        return "index";
                    }
                }
            }
        }
        return "index";
    }

    @RequestMapping(path = "404")
    public String noFound(){
        return "404";
    }
    @RequestMapping(path = "/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(path = "/landing")
    public String landing() {
        return "landing";
    }
}
