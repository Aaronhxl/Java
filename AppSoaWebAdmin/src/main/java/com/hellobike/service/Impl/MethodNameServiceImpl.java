package com.hellobike.service.Impl;

import com.hellobike.dao.IMethodNameDao;
import com.hellobike.service.IMethodNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MethodNameServiceImpl implements IMethodNameService {

    @Autowired
    private IMethodNameDao methodNameDao;
    @Override
    public Integer findIdByMethodName(String method_name) {
        return methodNameDao.findIdByMethodName(method_name);
    }

    @Override
    public void insertMethodName(String method_name) {

        if(findIdByMethodName(method_name)== null){
            methodNameDao.insertMethodName(method_name);
        }
    }
}
