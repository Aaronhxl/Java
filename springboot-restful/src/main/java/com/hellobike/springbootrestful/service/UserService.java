package com.hellobike.springbootrestful.service;


import com.hellobike.springbootrestful.bean.User;

public interface UserService {
    /**
     * 插入一条用户记录
     * @param user
     */
    void insertUser(User user);
}
