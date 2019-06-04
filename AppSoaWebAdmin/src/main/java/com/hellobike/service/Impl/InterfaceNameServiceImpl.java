package com.hellobike.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hellobike.dao.IInterfaceNameDao;
import com.hellobike.domain.InterfaceName;
import com.hellobike.service.IInterfaceNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterfaceNameServiceImpl extends ServiceImpl<IInterfaceNameDao, InterfaceName> implements IInterfaceNameService  {

    @Autowired
    private IInterfaceNameDao interfaceNameDao;
    @Override
    public Integer findIdByInterfaceName(String interface_name) {
        return interfaceNameDao.findIdByInterfaceName(interface_name);
    }

    @Override
    public void insertInterfaceName(String interface_name) {

        if(findIdByInterfaceName(interface_name) == null){
            interfaceNameDao.insertInterfaceName(interface_name);
        }
    }
}
