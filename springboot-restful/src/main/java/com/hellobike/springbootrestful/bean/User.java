package com.hellobike.springbootrestful.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 用户实体类
 */

@Data
@Component
public class User {
    private String name;
    private Integer age;

}
