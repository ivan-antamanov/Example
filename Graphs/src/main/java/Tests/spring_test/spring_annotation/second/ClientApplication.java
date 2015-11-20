package Tests.spring_test.spring_annotation.second;

/**
 * Created by iantaman on 18.11.2015.
 */
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);

        app.processMessage("Hi Pankaj", "pankaj@abc.com");

        //close the context
        context.close();
    }

}