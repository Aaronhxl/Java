package com.hellobike.controller;

import com.hellobike.domain.User;
import com.hellobike.service.IInterfaceNameService;
import com.hellobike.service.IMethodNameService;
import com.hellobike.service.IServiceNameService;
import com.hellobike.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.xml.ws.Service;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        model.addAttribute("users", users);
        return "list";
    }


}
