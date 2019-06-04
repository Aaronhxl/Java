package com.hellobike.domain;

import lombok.Data;

/**
 * service_name
 * ip
 * port
 * interface_name
 * method_name
 * params
 * result_params
 */

public class ResultRecord {

    private String service_name;
    private String ip;
    private String port;
    private String interface_name;
    private String method_name;
    private String params;
    private String result_params;

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getInterface_name() {
        return interface_name;
    }

    public void setInterface_name(String interface_name) {
        this.interface_name = interface_name;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

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

    @Override
    public String toString() {
        return "ResultRecord{" +
                "service_name='" + service_name + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", interface_name='" + interface_name + '\'' +
                ", method_name='" + method_name + '\'' +
                ", params='" + params + '\'' +
                ", result_params='" + result_params + '\'' +
                '}';
    }
}
