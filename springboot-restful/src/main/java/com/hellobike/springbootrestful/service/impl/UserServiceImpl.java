package com.hellobike.springbootrestful.service.impl;

import com.hellobike.springbootrestful.bean.User;
import com.hellobike.springbootrestful.dao.UserDao;
import com.hellobike.springbootrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
