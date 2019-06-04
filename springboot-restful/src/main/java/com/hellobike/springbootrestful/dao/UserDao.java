package com.hellobike.springbootrestful.dao;

import com.hellobike.springbootrestful.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    /**
     * 插入一条用户记录
     * @param user
     */
    void insertUser(User user);
}
