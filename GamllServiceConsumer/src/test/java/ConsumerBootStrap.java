import com.hellobike.service.OrderService;
import com.hellobike.service.OrderServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 测试Rpc
 */
public class ConsumerBootStrap {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        OrderService orderService = ioc.getBean(OrderServiceImpl.class);
        orderService.initUser("1");
        System.in.read();
    }
}
