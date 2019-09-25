package com.yhb.dao;

import com.yhb.domain.User;

/**
 * @author YangHaiBo
 * @create 2019-09-25 15:12
 */
public interface UserMapper {
    /**
     * 查询数据库是否有对应的User
     * @param user 传入User对象
     * @return User
     */
    User getUser(User user);

    /**
     * 更新用户信息
     * @param user 更新后的用户对象
     */
    void updateUser(User user);

    /**
     * 通过Token查询用户
     * @param token session里面的信息
     * @return user
     */
    User searchUserByToken(String token);
}
