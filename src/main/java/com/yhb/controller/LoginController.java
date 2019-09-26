package com.yhb.controller;

import com.yhb.domain.User;
import com.yhb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @author YangHaiBo
 * @create 2019-09-25 15:06
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //如果已经登录跳转主界面(即浏览器有登录token)
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    response.setCharacterEncoding("GBK");
                    PrintWriter out = response.getWriter();
                    out.println("<script>alert('已经登录'); window.location='/' </script>");
                    out.flush();
                    out.close();
                    return "redirect:/";
                }
            }
        }
        return "login";
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "password", required = false) String password,
                             HttpServletResponse response, HttpServletRequest request) throws IOException {
        User user = new User();
        user.setUserName(name);
        user.setUserPassword(password);

        //登录验证
        if (userService.checkedUser(user)) {
            //生成一个token
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            //更新user
            userService.updateUser(user);
            //将token添加到Cookie和Session中
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);

            request.getSession().setAttribute("user", user);
            return "redirect:/";
        } else {
            //没有用户 重回登录页面
            response.setCharacterEncoding("GBK");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('登录密码错误或没有当前账号'); window.location='login' </script>");
            out.flush();
            out.close();
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        //删除浏览器中用户信息
        request.getSession().removeAttribute("user");
        //清理token信息
        Cookie cookie = new Cookie("token", null);
        //清理cookie信息
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "/login";
    }
}
