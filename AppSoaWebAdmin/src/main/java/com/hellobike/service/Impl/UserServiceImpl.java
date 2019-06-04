package com.hellobike.service.Impl;

import com.hellobike.dao.IUserDao;
import com.hellobike.domain.User;
import com.hellobike.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}
