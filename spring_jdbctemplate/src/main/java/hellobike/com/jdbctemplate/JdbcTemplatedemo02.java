package hellobike.com.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * spring jdbctemplate的简单使用
 */
public class JdbcTemplatedemo02 {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean(JdbcTemplate.class);
        jt.execute("insert into account(name,money) values ('txl',2000)");
    }
}
