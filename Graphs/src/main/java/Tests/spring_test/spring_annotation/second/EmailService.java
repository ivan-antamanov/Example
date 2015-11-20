package Tests.spring_test.spring_annotation.second;

/**
 * Created by iantaman on 18.11.2015.
 */
public class EmailService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("msg");
        return false;
    }
}