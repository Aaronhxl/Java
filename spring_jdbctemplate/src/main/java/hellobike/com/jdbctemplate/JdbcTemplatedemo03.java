package hellobike.com.jdbctemplate;

import hellobike.com.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * spring jdbctemplate的CRUD
 */
public class JdbcTemplatedemo03 {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean(JdbcTemplate.class);

        //查询所有记录
       // List<Account> list = jt.query("select * from account where money > ?", new AccountRowMapper(), 1000);
        //spring 提供了实现类
        List<Account> list = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000);
        for (Account account : list) {
            System.out.println(account);
        }

        Integer count = jt.queryForObject("select count(*) from account where id = ?", Integer.class, 1);
        System.out.println(count);
    }
}

class AccountRowMapper implements RowMapper<Account>{

    /**
     * 定义封装结果集的规则
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getDouble("money"));
        return account;
    }
}