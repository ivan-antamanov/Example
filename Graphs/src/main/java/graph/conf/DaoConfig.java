package graph.conf;

import graph.dao.impl.DaoObjectImpl;
import graph.web.GraphController;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by iantaman on 19.11.2015.
 */
@Configuration
//@Import({BOConfiguration.class, GraphController.class})
public class DaoConfig {

    @Bean
    public DaoObjectImpl daoObject(){
        return new DaoObjectImpl();
    }
}
