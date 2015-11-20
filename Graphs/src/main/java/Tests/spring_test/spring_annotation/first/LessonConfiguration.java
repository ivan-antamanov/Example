package Tests.spring_test.spring_annotation.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * Created by iantaman on 17.11.2015.
 */
@Configuration
@ComponentScan
public class LessonConfiguration {
    @Bean(name = {"gServiceName", "gServiceAnotherNamed"})
    @Description("Текстовое описание бина greetingService")
    GreetingService greetingService(){
        return new GreetingServiceImpl();
    }
}
