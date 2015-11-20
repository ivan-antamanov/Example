package Tests.web_test.rest_spring;

/**
 * Created by iantaman on 16.11.2015.
 */
public class Greeting {
    private final long id;
    private final String context;

    public Greeting(long id, String context) {
        this.id = id;
        this.context = context;
    }

    public long getId() {
        return id;
    }

    public String getContext() {
        return context;
    }
}
