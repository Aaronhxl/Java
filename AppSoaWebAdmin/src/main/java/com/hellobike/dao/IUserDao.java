package com.hellobike.dao;

import com.hellobike.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    List<User> findAll();

}
