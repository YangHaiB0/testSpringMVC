package com.yhb.service.impl;

import com.yhb.dao.StudentMapper;
import com.yhb.domain.Student;
import com.yhb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangHaiBo
 * @create 2019-09-23 18:37
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentById(Integer id) {
        return studentMapper.searchById(id);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentMapper.searchByName(name);
    }

    @Override
    public List<Student> getStudentAll() {
        return studentMapper.searchAll();
    }
}
