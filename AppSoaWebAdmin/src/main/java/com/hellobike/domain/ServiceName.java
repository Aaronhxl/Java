package com.hellobike.domain;

/**
 * 服务的实体类：包含服务名+IP+port
 */
public class ServiceName {
    private Integer id;
    private String service_name;
    private String ip;
    private String port;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    @Override
    public String toString() {
        return "ServiceName{" +
                "id=" + id +
                ", service_name='" + service_name + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
