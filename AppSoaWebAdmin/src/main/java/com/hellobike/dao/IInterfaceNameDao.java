package com.hellobike.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hellobike.domain.InterfaceName;
import org.springframework.stereotype.Repository;

@Repository
public interface IInterfaceNameDao extends BaseMapper<InterfaceName> {

    Integer findIdByInterfaceName(String interface_name);
    void insertInterfaceName(String interface_name);
}
