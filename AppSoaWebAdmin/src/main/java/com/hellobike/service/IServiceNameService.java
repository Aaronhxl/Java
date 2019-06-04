package com.hellobike.service;

import com.hellobike.domain.ServiceName;

public interface IServiceNameService {

    int findIdByServiceName(ServiceName service_name);
    void insertServiceName(ServiceName service_name);
}
