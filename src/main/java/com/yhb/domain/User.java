package com.yhb.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YangHaiBo
 * @create 2019-09-25 15:10
 */
@Data
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userQq;
    private String userInfo;
    private String token;
    private boolean isAdmin;
}
