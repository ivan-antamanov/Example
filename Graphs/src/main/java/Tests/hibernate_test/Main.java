package Tests.hibernate_test;

import graph.conf.BOConfiguration;
import graph.conf.DaoConfig;
import graph.conf.DataSourceConfiguration;
import graph.dao.impl.DaoObjectImpl;
import graph.web.GraphController;
import graph.web.NodeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iantaman on 24.11.2015.
 */

@Configuration
@ComponentScan(value = {"Tests.hibernate_test.conf","Tests.hibernate_test.dao"})
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }
}
