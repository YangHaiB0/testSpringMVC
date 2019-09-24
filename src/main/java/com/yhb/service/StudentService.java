package com.yhb.service;

import com.github.pagehelper.PageInfo;
import com.yhb.domain.Student;

/**
 * 调用mapper接口
 * @author YangHaiBo
 * @create 2019-09-23 18:37
 */
public interface StudentService {
//    /**
//     * 通过学生Id获得学生
//     * @param id 学生ID
//     * @return Student
//     */
//    List<Student> getStudentById(Integer id);
//
//    /**
//     * 通过学生姓名获得学生
//     * @param name 学生姓名
//     * @return List
//     */
//    List<Student> getStudentByName(String name);

    /**
     * 获得数据库中所有学生信息
     * @return List
     */
    PageInfo<Student> getStudentAll(Integer page, Integer pageSize);

    /**
     * 通过名字或ID查询
     * @param student 学生ID或者名字
     * @return List
     */
    PageInfo<Student> getStudentBy(Student student);

}
