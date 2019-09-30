package com.yhb.controller;

import com.yhb.dao.StudentMapper;
import com.yhb.dao.UserMapper;
import com.yhb.domain.Student;
import com.yhb.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author YangHaiBo
 * @create 2019-09-28 14:03
 */
@Controller
public class AdminController {
    private static final Log log = LogFactory.getLog(AdminController.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/adminUpdateOrCreateUser")
    public String updateUser(Model model,
                             @RequestParam(name = "id",required = false) Integer id,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "password",required = false) String password,
                             @RequestParam(name = "email") String email,
                             @RequestParam(name = "qq") String qq,
                             @RequestParam(name = "info") String info,
                             @RequestParam(name = "checked", required = false) String isAdmin) {
        User user = new User();
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserQq(qq);
        user.setUserInfo(info);
        if (isAdmin != null) {
            user.setUserPassword(password);
            user.setAdmin("isAdmin".equals(isAdmin));
            userMapper.createUser(user);
            log.info("create user " + user.toString());
            return "redirect:/adminUser";
        }
        user.setUserId(id);
        userMapper.updateUserById(user);
        log.info("update user " + user.toString());
        return "redirect:/adminUser";
    }

    @RequestMapping("/adminDeleteUser")
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        userMapper.deleteUserById(id);
        log.info("delete user ,user id is " + id);
        return "redirect:/adminUser";
    }

    @RequestMapping("/adminStudent")
    public String adminStudent(Model model) {
        // TODO: 2019-09-28 传入所有学生信息
        List<Student> students = studentMapper.searchAll();
        model.addAttribute("studentInfo", students);
        return "admin-student";
    }

    @RequestMapping("/adminInformation")
    public String adminInformation(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id != null) {
            //id不为空,表示是更新用户信息
            model.addAttribute("user", userMapper.searchUserById(id));
        } else {
            //id为空,表示是新增用户
            model.addAttribute("user", new User());
        }
        return "admin-information";
    }

    @RequestMapping("/adminUser")
    public String adminUser(Model model) {
        List<User> userAll = userMapper.getUserAll();
        model.addAttribute("userInfo", userAll);
        return "admin-user";
    }

    @RequestMapping("/adminLogout")
    public String adminLogOut() {
        return "redirect:/logout";
    }
}
