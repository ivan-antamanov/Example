package Tests.hibernate_test.conf;

import Tests.hibernate_test.dao.GraphDAOImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iantaman on 27.11.2015.
 */
@Configuration
//@ComponentScan("Tests.hibernate_test.conf")
public class DAOConfig {

//    @Autowired
//    private SessionFactory sessionFactory;

    @Bean
    public GraphDAOImpl graphDAO(SessionFactory sessionFactory){
        return new GraphDAOImpl(sessionFactory);
    }
}