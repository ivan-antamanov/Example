package Tests.hibernate_test.conf;

import Tests.hibernate_test.dao.GraphDAOImpl;
//import Tests.hibernate_test.service.GraphService;
import Tests.hibernate_test.service.GraphServiceImpl;
import graph.dao.impl.DaoObjectImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iantaman on 27.11.2015.
 */
@Configuration
//@ComponentScan(value = {"Tests.hibernate_test.web"})
public class ServiceConfig{
//    @Autowired
//    private GraphDAOImpl graphDAO;

    @Bean
    public GraphServiceImpl graphService(GraphDAOImpl graphDAO){
        return new GraphServiceImpl(graphDAO);
    }


}


