package com.yhb.service.impl;

import com.yhb.dao.StudentMapper;
import com.yhb.domain.Student;
import com.yhb.jedis.JedisClient;
import com.yhb.service.StudentService;
import com.yhb.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private JedisClient jedisClient;


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
        List<Student> returnStudentsList;
        String studentAllJsonNameInRedis = "test_stu_studentAll";
        String studentJson = jedisClient.get(studentAllJsonNameInRedis);
        if (StringUtils.isBlank(studentJson)) {
            returnStudentsList = studentMapper.searchAll();
            String studentToJson = JsonUtils.objectToJson(returnStudentsList);
            jedisClient.set(studentAllJsonNameInRedis, studentToJson);
        }else {
            returnStudentsList = (List<Student>) JsonUtils.jsonToPojo(studentJson, List.class);
        }

        return returnStudentsList;
    }
}
