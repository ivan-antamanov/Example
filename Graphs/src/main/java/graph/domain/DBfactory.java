package graph.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by iantaman on 09.11.2015.
 */
@Component
public class DBfactory {

//    @Autowired
    private DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);

    }

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
