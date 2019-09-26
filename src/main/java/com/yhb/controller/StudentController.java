package com.yhb.controller;

import com.github.pagehelper.PageInfo;
import com.yhb.domain.Student;
import com.yhb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YangHaiBo
 * @create 2019-09-23 16:51
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getStudentAll")
    public String getStudentAll(Model model,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize) {
        PageInfo<Student> studentList = studentService.getStudentAll(page, pageSize);
        model.addAttribute("studentPageInfo", studentList);
        model.addAttribute("requestMapping","getStudentAll");
        model.addAttribute("searchId",null);
        model.addAttribute("searchName",null);
        return "/index";
    }

    @RequestMapping("/getStudent")
    public String getStudentBy(Model model,
                               @RequestParam(value = "id", required = false) Integer id,
                               @RequestParam(value = "name", required = false) String name) {
        Student student = new Student();
        student.setStudentId(id);
        student.setStudentName(name);

        PageInfo<Student> studentBy = studentService.getStudentBy(student);
        model.addAttribute("studentPageInfo", studentBy);
        model.addAttribute("requestMapping","getStudent");
        model.addAttribute("searchId",id);
        model.addAttribute("searchName",name);
        return "/index";
    }

}
