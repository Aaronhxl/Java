package hellobike.com.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * spring jdbctemplate的简单使用
 */
public class JdbcTemplatedemo01 {
    public static void main(String[] args) {
        //准备数据源，使用spring内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring");
        ds.setUsername("root");
        ds.setPassword("hl199664");

        //使用jdbcTemplate
        JdbcTemplate jt = new JdbcTemplate(ds);
        jt.execute("insert into account(name,money) values ('wyy',2000)");


    }
}
