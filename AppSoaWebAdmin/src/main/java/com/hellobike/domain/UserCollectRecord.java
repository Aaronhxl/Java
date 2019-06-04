package com.hellobike.domain;

/**
 * 用户收藏记录实体类
 */
public class UserCollectRecord {
    private Integer id;
    private Integer service_id;
    private Integer interface_id;
    private Integer method_id;
    private Integer user_id;
    private String params;
    private String result_params;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getResult_params() {
        return result_params;
    }

    public void setResult_params(String result_params) {
        this.result_params = result_params;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Integer getInterface_id() {
        return interface_id;
    }

    public void setInterface_id(Integer interface_id) {
        this.interface_id = interface_id;
    }

    public Integer getMethod_id() {
        return method_id;
    }

    public void setMethod_id(Integer method_id) {
        this.method_id = method_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserCollectRecord{" +
                "id=" + id +
                ", service_id=" + service_id +
                ", interface_id=" + interface_id +
                ", method_id=" + method_id +
                ", user_id=" + user_id +
                ", params='" + params + '\'' +
                ", result_params='" + result_params + '\'' +
                '}';
    }
}
