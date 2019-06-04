package com.hellobike.service;


import com.hellobike.bean.UserAddress;

import java.util.List;

public interface UserService {
    List<UserAddress> getUserAdressList(String userId);
}
