package graph.web;

import graph.bo.BusinessObject;
import graph.domain.Graph;
import graph.domain.NodeData;
import graph.web.urlConstants.URLConstants;
import org.omg.CORBA.NO_IMPLEMENT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by iantaman on 20.11.2015.
 */
@RestController
@RequestMapping("/node")
public class NodeController {

    private static final Logger logger = Logger.getLogger(NodeController.class.getName());

    @Autowired
    private BusinessObject businessObject;

    public void setBusinessObject(BusinessObject businessObject) {
        this.businessObject = businessObject;
    }

    @RequestMapping(value = URLConstants.CREATE_NODE, method = RequestMethod.POST)
    public NodeData createNode(@RequestBody String name) {
        logger.info("Creating node in WEB");
        NodeData node = businessObject.createNode(name);
        return node;
    }

    @RequestMapping(value = URLConstants.GET_NODE, method = RequestMethod.GET)
    public NodeData getNode(@PathVariable String name) {
        logger.info("Get node in WEB");
        NodeData node = businessObject.getNodeByName(name);
        return node;
    }

    @RequestMapping(value = URLConstants.GET_NODE_LIST, method = RequestMethod.GET)
//    @ResponseBody
    public List<NodeData> getListNodes(@RequestParam String name) {
    logger.info("Try to get nodes in some graph: "+name);
        return businessObject.getListNodesByGraph(name);
    }


    @RequestMapping(value = URLConstants.UPDATE_NODE, method = RequestMethod.PUT)
    public NodeData updateNode(@PathVariable("initialName") String initialName, String newName, String graphName) {
        logger.info("Updating node in WEB with old name: " +
                ""+initialName+" to new name "+ newName+" and add graph "+ graphName);
        businessObject.updateNode(initialName,newName,graphName);
        return businessObject.getNodeByName(newName);
    }

    @RequestMapping(value = URLConstants.DELETE_NODE, method = RequestMethod.DELETE)
    public NodeData deleteNode(@PathVariable("name") String nodeName){
        logger.info("Try delete node in WEB with name: " + nodeName);
        if (businessObject.deleteNode(nodeName) != null){
            logger.info("Node "+nodeName+" has been deleted");
            return new NodeData();
        }
        logger.info("Can't delete node: "+nodeName);
        return null;
    }
}
