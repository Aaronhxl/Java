package com.hellobike.domain;

/**
 * 方法名实体类
 */
public class MethodName {
    private Integer id;
    private String method_name;

    @Override
    public String toString() {
        return "MethodName{" +
                "id=" + id +
                ", method_name='" + method_name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }
}
