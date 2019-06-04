package com.hellobike.domain;

import lombok.*;

/**
 * jsp数据与后台数据绑定
 */
@Data
public class Record {
    private ServiceName serviceName;
    private String interfaceName;
    private String methodName;
    private String params;
    private String resultParams;
    private Integer userId;

}


