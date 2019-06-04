package com.hellobike.controller;

import com.hellobike.bean.UserAddress;
import com.hellobike.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/init")
    @ResponseBody
    public List<UserAddress> inti(@RequestParam(name = "userId") String userId){
        return orderService.initUser(userId);
    }
}
