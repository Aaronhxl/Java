import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 测试
 */
public class ProviderBootStrap {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:provider.xml");
        ioc.start();
        System.in.read();
    }
}
