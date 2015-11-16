package graph.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

/**
 * Created by iantaman on 09.11.2015.
 */
public class DBfactory {


    private DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    private DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);

    }

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
