import graph.web.urlConstants.URLConstants;
import org.springframework.web.client.RestTemplate;

/**
 * Created by iantaman on 20.11.2015.
 */
public class TestWeb {

    public static final String SERVER_URL = "http://localhost:8080/graph";

    public static void tetsCreateGraph() {
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String name = "NewGraph";
//        URI uri = restTemplate.postForLocation(SERVER_URL + URLConstants.CREATE_GRAPH, name, Graph.class);
        String initailName = "TestGraph";
        String newName = "GraphTest";
        restTemplate.put(SERVER_URL +URLConstants.UPDATE_GRAPH, newName, "New");


    }
    public static void main(String[] args) {
        tetsCreateGraph();
    }
}
