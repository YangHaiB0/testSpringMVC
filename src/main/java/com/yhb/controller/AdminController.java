package com.yhb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YangHaiBo
 * @create 2019-09-28 14:03
 */
@Controller
public class AdminController {

    @RequestMapping("/createOrUpdateUser")
    public String createOrUpdateUser(){

        return null;
    }

    @RequestMapping("/adminStudent")
    public String adminStudentController(){
        //传入所有学生信息
        return "admin-student";
    }

    @RequestMapping("/adminUser")
    public String adminUserController(){
        //传入所有用户信息
        return "admin-user";
    }

    @RequestMapping("/adminLogout")
    public String adminLogOut(){
        return "redirect:/logout";
    }
}
