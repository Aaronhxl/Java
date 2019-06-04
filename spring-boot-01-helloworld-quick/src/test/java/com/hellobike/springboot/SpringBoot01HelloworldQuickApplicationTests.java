package com.hellobike.springboot;

import com.hellobike.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot的单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01HelloworldQuickApplicationTests {

    @Autowired
    private Person person;
    @Autowired
    private ApplicationContext ioc;

    @Test
    public void testIoc(){
        System.out.println(ioc.containsBean("helloService"));
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
