package com.yhb.service;

import com.yhb.domain.Student;

import java.util.List;

/**
 * 调用mapper接口
 * @author YangHaiBo
 * @create 2019-09-23 18:37
 */
public interface StudentService {
    /**
     * 通过学生Id获得学生
     * @param id 学生ID
     * @return Student
     */
    List<Student> getStudentById(Integer id);

    /**
     * 通过学生姓名获得学生
     * @param name 学生姓名
     * @return List
     */
    List<Student> getStudentByName(String name);

    /**
     * 获得数据库中所有学生信息
     * @return List
     */
    List<Student> getStudentAll();


}
