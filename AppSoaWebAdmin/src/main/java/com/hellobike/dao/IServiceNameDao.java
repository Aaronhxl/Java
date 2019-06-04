package com.hellobike.dao;

import com.hellobike.domain.ServiceName;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceNameDao {

    Integer findIdByServiceName(ServiceName service_name);
    void insertServiceName(ServiceName service_name);
}
