package Tests.hibernate_test.web;

import Tests.hibernate_test.model.GraphModel;
import Tests.hibernate_test.service.GraphService;
import Tests.hibernate_test.service.GraphServiceImpl;
import graph.web.urlConstants.URLConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.log4j.Logger;

/**
 * Created by iantaman on 27.11.2015.
 */
@RestController
@RequestMapping("/graph")
@ComponentScan("Tests.hibernate_test.service")
public class GraphModelController {

    private static final Logger logger = Logger.getLogger(GraphModelController.class.getName());

    @Autowired
    @Qualifier("graphServiceImpl")
    private GraphService<GraphModel> graphService;

    @RequestMapping(value = URLConstants.CREATE_GRAPH, method = RequestMethod.POST)
    public GraphModel createGraph(@RequestBody String name){
        logger.info("Creating graph in WEB with name: " + name);
        GraphModel graphModel = graphService.create(name);
        return graphModel;
    }

}
