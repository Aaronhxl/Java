package com.hellobike.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface IMethodNameDao {

    Integer findIdByMethodName(String method_name);
    void insertMethodName(String method_name);
}
