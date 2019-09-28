package com.yhb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhb.dao.StudentMapper;
import com.yhb.domain.Student;
import com.yhb.jedis.JedisClient;
import com.yhb.service.StudentService;
import com.yhb.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangHaiBo
 * @create 2019-09-23 18:37
 */
@Service
public class StudentServiceImpl implements StudentService {
    public static final Log log = LogFactory.getLog(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public PageInfo<Student> getStudentAll(Integer page, Integer pageSize){

        try {
            //从Redis中获取student数据
            String studentAllJsonNameInRedis = "test_stu_studentAll_";
            String studentJson = this.jedisClient.get(studentAllJsonNameInRedis + page);
            //判断studentJson是否为空
            if (StringUtils.isBlank(studentJson)) {
                //设置分页数据
                PageHelper.startPage(page, pageSize);
                //从数据库中查询数据
                List<Student> studentsList = this.studentMapper.searchAll();
                //PageHelper生成pageInfo
                PageInfo<Student> pageInfo = new PageInfo<>(studentsList);
                pageInfo.setPageNum((page < 1) ? 1 : page);
                pageInfo.setPageNum((page > pageInfo.getPages()) ? pageInfo.getPages() : page);
                //转换为json数据
                String studentsJson = JsonUtils.objectToJson(pageInfo);
                //存入数据库
                this.jedisClient.set(studentAllJsonNameInRedis + pageInfo.getPageNum(), studentsJson);
                this.jedisClient.expire(studentAllJsonNameInRedis + pageInfo.getPageNum(), 3600);
                return pageInfo;
            } else {
                //重新设置存活时间
                this.jedisClient.expire(studentAllJsonNameInRedis + page, 3600);
                //将Redis获取数据转换为pageInfo对象
                return JsonUtils.jsonToPojo(studentJson, PageInfo.class);
            }
        } catch (Exception e) {
            log.debug(e);
            return null;
        }
    }

    @Override
    public PageInfo<Student> getStudentBy(Student student) {
        PageHelper.startPage(1, 4);
        return new PageInfo<>(studentMapper.searchBy(student));
    }
}
