package Tests.spring_test.spring_annotation.second;

/**
 * Created by iantaman on 18.11.2015.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"Tests.spring_test.spring_annotation.second"})
public class DIConfiguration {

    @Bean
    public MessageService getMessageService(){
        return new EmailService();
    }
}