package Tests.spring_test.spring_annotation.first;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by iantaman on 17.11.2015.
 */
public class Starter {

    private static final Logger logger = LogManager.getLogger(String.class);

    public static void main(String[] args) {
        logger.info("Starting conf...");

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
         AbstractApplicationContext context = new AnnotationConfigApplicationContext(LessonConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
//        context.register(LessonConfiguration.class);
//        context.refresh();

        logger.info(greetingService.sayGreeting());
        context.registerShutdownHook();
    }




}
