package com.hellobike.springboot.config;

import com.hellobike.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指明当前类是一个配置类：就是用来代替之前的Spring的配置文件
 */
@Configuration
public class MyAppconfig {

    /**
     * 将方法的返回值添加到容器中：容器的这个组件的默认ID就是方法名
     * @return
     */
    @Bean
    public HelloService helloService(){
        System.out.println("添加组件");
        return new HelloService();
    }

}
