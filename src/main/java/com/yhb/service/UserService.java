package com.yhb.service;

import com.yhb.domain.User;

/**
 * @author YangHaiBo
 * @create 2019-09-25 15:19
 */
public interface UserService {
    /**
     * 检测数据库是否有User
     * @param user 输入的用户信息
     * @return boolean
     */
    boolean checkedUser(User user);

    /**
     * 更新用户
     * @param user 更新用户
     */
    void updateUser(User user);

    /**
     * 通过token查询用户
     * @param token session里面的token信息
     */
    void selectUser(String token);
}
