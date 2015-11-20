package Tests.spring_test.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by iantaman on 06.11.2015.
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext( new String[] {"Spring-Customer.xml"});
        CustomerService customerService = (CustomerService) applicationContext.getBean("customerServiceProxy");
        //point at (��������� ��) id with name "customerService" and transformation to CustomerService object

        System.out.println("********");
        customerService.printName();
        System.out.println("********");
        customerService.printURL();
        System.out.println("********");
        try {
            customerService.printThrowException();
        } catch (Exception e){

        }

    }

}
