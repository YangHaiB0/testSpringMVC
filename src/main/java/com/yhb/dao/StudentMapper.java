package com.yhb.dao;


import com.yhb.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 映射接口
 * @author YangHaiBo
 * @create 2019-09-20 18:44
 */
@Repository("StudentMapper")
public interface StudentMapper {

    List<Student> searchAll();

    List<Student> searchByName(String name);

    List<Student> searchById(Integer id);


}
