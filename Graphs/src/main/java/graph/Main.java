package graph;

//import graph.conf.BOConfiguration;
import graph.bo.BusinessObject;
import graph.conf.BOConfiguration;
import graph.conf.DaoConfig;
import graph.conf.DataSourceConfiguration;
import graph.dao.impl.DaoObjectImpl;
//import graph.dao.impl.NodeDataDaoImpl;
import graph.domain.*;
import graph.web.GraphController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Created by iantaman on 09.11.2015.
 */
@SpringBootApplication
public class Main {

//    private ApplicationContext context;
//    private DBfactory dBfactory;
//    private BusinessObject businessObject;
//    private Logger logger = Logger.getLogger(Main.class.getName());

    public Main() {
//        context = new ClassPathXmlApplicationContext("Spring-Datasource.xml");
//        context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class, DaoConfig.class);
//        dBfactory = context.getBean(DBfactory.class);
//        GraphController graphController = context.getBean(GraphController.class);
//        graphController.setBusinessObject(businessObject);
    }

//    public Main(String configLocation, String beanId) {
//        validation(configLocation, beanId);
//
//    }

//    private void validation(String configLocation, String beanId) {
//        try {
//            this.context = new ClassPathXmlApplicationContext(configLocation);
//
//            dBfactory = (DBfactory) context.getBean(beanId);
//            businessObject = new BusinessObject(new DaoObjectImpl());
//        } catch (Exception e) {
//            logger.info("Please, check your file name\\location;");
//        }
//    }

//    public BusinessObject getBusinessObject() {
//        return businessObject;
//    }

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }
}
