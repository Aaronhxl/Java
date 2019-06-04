package com.hellobike.service;

import com.hellobike.bean.UserAddress;

import java.util.List;

public interface OrderService {

    List<UserAddress> initUser(String userId);
}
