package com.yhb.service.impl;

import com.yhb.dao.UserMapper;
import com.yhb.domain.User;
import com.yhb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YangHaiBo
 * @create 2019-09-25 15:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkedUser(User user) {
        return userMapper.getUser(user) != null;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void selectUser(String token) {

    }
}
