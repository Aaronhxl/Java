package com.hellobike.service;
import com.hellobike.bean.UserAddress;
import java.util.Arrays;
import java.util.List;

/**
 *  1.将服务提供者注册到注册中心
 *      1）导入dubbo依赖(2.6.2),导入Zookeeper客户端
 *      2）配置服务提供者
 *  2.让服务消费者去注册中心订阅服务提供者的服务地址
 */

public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAdressList(String userId) {
        UserAddress userAddress1 = new UserAddress(1, "江西上饶", "000001",
                "黄龙", "18779302235", "是");
        return Arrays.asList(userAddress1);
    }
}
