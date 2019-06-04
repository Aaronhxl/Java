package com.hellobike.service;

import com.hellobike.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    List<User> findAll();
}
