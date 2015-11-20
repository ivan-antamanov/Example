package Tests.spring_test.spring_annotation.first;

/**
 * Created by iantaman on 17.11.2015.
 */
public class GreetingServiceImpl implements GreetingService {


    @Override
    public String sayGreeting() {
        return "Greeting, user!";
    }
}
