package com.yhb.controller;

import com.yhb.domain.Student;
import com.yhb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author YangHaiBo
 * @create 2019-09-23 16:51
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getStudentAll")
    public String getStudentAll(Model model) {
        List<Student> studentList = studentService.getStudentAll();
        model.addAttribute("student", studentList);
        return "/index";
    }

    @RequestMapping("/getStudentById")
    public String getStudentById(Model model,
                             @RequestParam(value = "id", required = true, defaultValue = "") Integer id) {
        List<Student> studentList = studentService.getStudentById(id);
        model.addAttribute("student", studentList);
        return "/index";
    }
    @RequestMapping("/getStudentByName")
    public String getStudentByName(Model model,
                             @RequestParam(value = "name", required = false,defaultValue = "") String name) {
        List<Student> studentList = studentService.getStudentByName(name);
        model.addAttribute("student", studentList);
        return "/index";
    }
}
