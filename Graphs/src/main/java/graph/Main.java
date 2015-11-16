package graph;

import graph.bo.BusinessObject;
import graph.dao.DaoObject;
import graph.dao.impl.DaoObjectImpl;
//import graph.dao.impl.NodeDataDaoImpl;
import graph.domain.DBfactory;
import graph.domain.Graph;
import graph.domain.NodeData;
import graph.domain.NodeReference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Created by iantaman on 09.11.2015.
 */
public class Main {

    private ApplicationContext context;
    private DBfactory dBfactory;
    private BusinessObject businessObject;
    private Logger logger = Logger.getLogger(Main.class.getName());

    public Main() {
        context = new ClassPathXmlApplicationContext("Spring-Datasource.xml");
        dBfactory = (DBfactory) context.getBean("dBfactory");
        businessObject = new BusinessObject(new DaoObjectImpl());
    }

    public Main(String configLocation, String beanId) {
        validation(configLocation, beanId);

    }

    private void validation(String configLocation, String beanId) {
        try {
            this.context = new ClassPathXmlApplicationContext(configLocation);

            dBfactory = (DBfactory) context.getBean(beanId);
            businessObject = new BusinessObject(new DaoObjectImpl());
        } catch (Exception e) {
            logger.info("Please, check your file name\\location;");
        }
    }

    public BusinessObject getBusinessObject() {
        return businessObject;
    }

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Datasource.xml");

        DBfactory dBfactory = (DBfactory) context.getBean("dBfactory");

        DaoObjectImpl daoObject = new DaoObjectImpl();

        BusinessObject businessObject = new BusinessObject(daoObject);


    }
}
