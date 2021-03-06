package com.hellobike.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hellobike.bean.UserAddress;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Reference
   private UserService userService;
    @Override
    public List<UserAddress> initUser(String userId) {
        System.out.println("rpc之前的参数："+userId);
        List<UserAddress> userAdressList = userService.getUserAdressList(userId);
        for (UserAddress userAddress : userAdressList) {
            System.out.println(userAddress);
        }
        System.out.println("rpc调用结束");
        return userAdressList;
    }
}
