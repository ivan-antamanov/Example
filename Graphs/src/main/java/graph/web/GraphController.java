package graph.web;

import graph.bo.BusinessObject;
import graph.domain.Graph;
import graph.web.controller.GraphURLConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by iantaman on 19.11.2015.
 */
@RestController
@RequestMapping("/graph")
public class GraphController {

    private static final Logger logger = Logger.getLogger(GraphController.class.getName());

    @Autowired
    private BusinessObject businessObject;

    public void setBusinessObject(BusinessObject businessObject) {
        this.businessObject = businessObject;
    }

    @RequestMapping(value = GraphURLConstants.GET_LIST_GRAPH, method = RequestMethod.GET)
    public List<Graph> listAllGrapg() {
        return businessObject.listAllGraph();
    }


    @RequestMapping(value = GraphURLConstants.GET_GRAPH, method = RequestMethod.GET)
    public Graph getGrahp(@PathVariable("name") String name) {
        logger.info("Start getGrahp()");
        Graph graph = businessObject.getGraphByName(name);
        if (graph != null) {
            return graph;
        }
        logger.warning("Graph with name: " + name + " not found");
        return new Graph();
    }

    @RequestMapping(value = GraphURLConstants.CREATE_GRAPH, method = RequestMethod.POST)
    public Graph createGraph(@RequestBody String name) {
        logger.info("Creating graph with name: " + name);
        Graph graph = businessObject.createGraph(name);
        return graph;

    }

    @RequestMapping(value = GraphURLConstants.UPDATE_GRAPH, method = RequestMethod.PUT)
    public Graph updateGraph(@PathVariable String initialName, String newName){
        logger.info("Updating graph with old name: " + initialName + " to new name: "+ newName);
        businessObject.updateGraph(initialName, newName);
return null;
    }
}
