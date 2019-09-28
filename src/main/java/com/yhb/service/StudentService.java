package com.yhb.service;

import com.github.pagehelper.PageInfo;
import com.yhb.domain.Student;

/**
 * 调用mapper接口
 * @author YangHaiBo
 * @create 2019-09-23 18:37
 */
public interface StudentService {
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
