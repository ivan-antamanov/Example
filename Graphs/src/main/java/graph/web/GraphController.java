package graph.web;

import graph.bo.BusinessObject;
import graph.domain.Graph;
import graph.web.urlConstants.URLConstants;
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

    @RequestMapping(value = URLConstants.CREATE_GRAPH, method = RequestMethod.POST)
    public Graph createGraph(@RequestBody String name) {
        logger.info("Creating graph in WEB with name: " + name);
        Graph graph = businessObject.createGraph(name);
        return graph;

    }

    @RequestMapping(value = URLConstants.GET_GRAPH_LIST, method = RequestMethod.GET)
    public List<Graph> getlistGraphs() {
        return businessObject.listAllGraph();
    }


    @RequestMapping(value = URLConstants.GET_GRAPH, method = RequestMethod.GET)
    public Graph getGrahp(@PathVariable("name") String name) {
        logger.info("Start getGrahp()");
        Graph graph = businessObject.getGraphByName(name);
        if (graph != null) {
            return graph;
        }
        logger.warning("Graph in WEB with name: " + name + " not found");
        return new Graph();
    }

    @RequestMapping(value = URLConstants.UPDATE_GRAPH, method = RequestMethod.PUT)
    public Graph updateGraph(@PathVariable("initialName") String initialName, @RequestBody String newName) {
        logger.info("Updating graph in WEB with old name: " + initialName + " to new name: " + newName);
        businessObject.updateGraph(initialName, newName);
        return businessObject.getGraphByName(newName);

    }

    @RequestMapping(value = URLConstants.DELETE_GRAPH, method = RequestMethod.DELETE)
    public Graph deleteGraph(@PathVariable String name){
        logger.info("Delete graph in WEB");
         if( businessObject.deleteGraph(name) !=null){
             return new Graph();
         }
        logger.warning("Can't delete graph: "+name);
        return null;
    }
}
