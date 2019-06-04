package com.hellobike.service.Impl;

import com.hellobike.dao.IServiceNameDao;
import com.hellobike.domain.ServiceName;
import com.hellobike.service.IServiceNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceNameServiceImpl implements IServiceNameService {

    @Autowired
    private IServiceNameDao serviceNameDao;

    @Override
    public int findIdByServiceName(ServiceName service_name) {
        return serviceNameDao.findIdByServiceName(service_name);
    }

    @Override
    public void insertServiceName(ServiceName service_name) {
        if(serviceNameDao.findIdByServiceName(service_name)== null){
            serviceNameDao.insertServiceName(service_name);
        }
    }
}
