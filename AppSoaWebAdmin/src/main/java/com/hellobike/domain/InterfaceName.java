package com.hellobike.domain;

/**
 * 接口名的实体类
 */
public class InterfaceName {
    private Integer id;
    private String interface_name;

    @Override
    public String toString() {
        return "InterfaceName{" +
                "id=" + id +
                ", interface_name='" + interface_name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterface_name() {
        return interface_name;
    }

    public void setInterface_name(String interface_name) {
        this.interface_name = interface_name;
    }
}
