package com.hellobike.springbootrestful.controller;

import com.hellobike.springbootrestful.bean.User;
import com.hellobike.springbootrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public void insertUser(){
       User user = new User();
       user.setName("hl");
       user.setAge(23);
       userService.insertUser(user);
    }
}
