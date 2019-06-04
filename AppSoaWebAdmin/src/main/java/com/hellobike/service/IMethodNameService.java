package com.hellobike.service;

import org.springframework.stereotype.Repository;


public interface IMethodNameService {

    Integer findIdByMethodName(String method_name);
    void insertMethodName(String method_name);
}
