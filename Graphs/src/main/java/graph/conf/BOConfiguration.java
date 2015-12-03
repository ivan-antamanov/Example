package graph.conf;

import graph.bo.BusinessObject;
import graph.dao.DaoObject;
import graph.dao.impl.DaoObjectImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iantaman on 19.11.2015.
 */
@Configuration
public class BOConfiguration {

//    @Autowired
//    public DaoObjectImpl daoObjectImpl;

    @Bean
    public BusinessObject businessObject(DaoObjectImpl daoObject){
        return new BusinessObject(daoObject);
    }
}
