package com.hellobike.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellobike.dao.IInterfaceNameDao;
import com.hellobike.domain.InterfaceName;
import org.springframework.stereotype.Repository;


public interface IInterfaceNameService  {

    Integer findIdByInterfaceName(String interface_name);
    void insertInterfaceName(String interface_name);
}
