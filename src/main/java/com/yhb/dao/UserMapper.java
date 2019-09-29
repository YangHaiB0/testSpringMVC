package com.yhb.dao;

import com.yhb.domain.User;

import java.util.List;

/**
 * @author YangHaiBo
 * @create 2019-09-25 15:12
 */
public interface UserMapper {
    /**
     * 查询数据库是否有对应的User
     *
     * @param user 传入User对象
     * @return User
     */
    User getUser(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> getUserAll();

    /**
     * 通过Id删除用户
     *
     * @param id 需要删除用户Id
     */
    void deleteUserById(Integer id);

    /**
     * 更新用户信息,用于登录验证
     *
     * @param user 更新后的用户对象
     */
    void updateUserToken(User user);

    /**
     * 通过Id更新用户信息
     *
     * @param user
     */
    void updateUserById(User user);

    /**
     * 通过Token查询用户,用户拦截登录验证
     *
     * @param token session里面的信息
     * @return user
     */
    User searchUserByToken(String token);

    /**
     * 通过Id查询用户
     *
     * @param id 用户Id
     * @return User
     */
    User searchUserById(Integer id);
}

