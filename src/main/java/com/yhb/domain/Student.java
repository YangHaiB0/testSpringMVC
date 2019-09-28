package com.yhb.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YangHaiBo
 * @create 2019-09-23 17:02
 */
@Data
public class Student implements Serializable {
    private Integer studentId;
    private String studentName;
}
