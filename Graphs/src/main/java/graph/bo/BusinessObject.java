package graph.bo;

import graph.dao.impl.DaoObjectImpl;
import graph.domain.DBfactory;
import graph.domain.Graph;
import graph.domain.NodeData;
import graph.domain.NodeReference;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by iantaman on 10.11.2015.
 */
public class BusinessObject {

    private DaoObjectImpl daoObject;
    private Logger logger = Logger.getLogger(BusinessObject.class.getName());

    public BusinessObject(DaoObjectImpl daoObject) {
        this.daoObject = daoObject;
    }

    public List<Graph> listAllGraph(){
        logger.info("Try to get list of graphs");
        return daoObject.allListGraph();
    }

    public Graph createGraph(String nameOfGraph) throws NullPointerException {
        logger.info("Try create Graph");
        if (!daoObject.isGraphExist(nameOfGraph)) {
            return daoObject.createGraph(nameOfGraph);

        } else {
            logger.warning("Table \"Graphs\" has already graph with name " + nameOfGraph + " ." +
                    " All graphs name's have to be unique");
        }

        return null;
    }

    public Graph getGraphByName(String graphsName) {
        logger.info("Try get Graph By Name");
        if (daoObject.isGraphExist(graphsName)) {
            return daoObject.readGraph(graphsName);
        } else {
            logger.warning("Not match graph with name " + graphsName + " in table!");
        }
        return null;
    }

    public void updateGraph(String initialName, String newName) {
        logger.info("Try update Graph");
        if (daoObject.isGraphExist(initialName)) {
            daoObject.updateGraph(initialName, newName);
        } else {
            logger.warning("Not match graph with name " + initialName + " in table!");
        }
    }

    public void deleteGraph(String graphsName) {
        logger.info("Try delete Graph By Name");
        if (daoObject.isGraphExist(graphsName)) {
            daoObject.deleteGraph(graphsName);
        } else {
            logger.warning("Not match graph with name " + graphsName + " in table!");
        }
    }
// graphs validation

    public NodeData createNode(String nodesName) {
        logger.info("Try create Node By Name");
        if (!daoObject.isNodeExist(nodesName)) {
            return daoObject.createNodeData(nodesName);
        } else {
            logger.warning("Table \"Node_Data\" has already node with name " + nodesName + " ." +
                    " All nodes name's have to be unique");
        }
        return null;
    }

    public NodeData getNodeByName(String nodeName) {
        logger.info("Try get Node By Name");
        if (daoObject.isNodeExist(nodeName)) {
            return daoObject.readNodeData(nodeName);
        } else {
            logger.info("Not match node with name " + nodeName + " in table!");
        }
        return null;
    }

    public void updateNode(String initialName, String newName, String addNameGraph) {
        logger.info("Try update Node");
        if (daoObject.isNodeExist(initialName) | daoObject.isGraphExist(addNameGraph)) {
            daoObject.updateNodeData(initialName, newName, addNameGraph);
        } else {
            logger.warning("Not match like initialNode name: " + initialName + " or graph name: " + addNameGraph);
        }
    }

    public void updateNode(String initialName, String addNameGraph) {
        logger.info("Try update Node");
        if (daoObject.isNodeExist(initialName)) {
            daoObject.updateNodeData(initialName, initialName, addNameGraph);
        } else {
            logger.warning("Not match node with name " + initialName + " in table!");
        }
    }

    public void deleteNode(String nodeName) {
        logger.info("Try delete Node By Name");

        try {
            if (daoObject.isNodeExist(nodeName)) {
                daoObject.deleteNodeData(nodeName);
            } else {
                logger.warning("Not match node with name " + nodeName + " in table!");
            }
        } catch (DataIntegrityViolationException e) {
            logger.warning("You have tried to delete which have a link. At first you must delete all link on this node");
        }
    }
// nodes validation

    public NodeReference createNodeReference(String nodeSourceId, String nodeTargetId) throws NullPointerException {
        logger.info("Try create reference By Names " + nodeSourceId + "-->" + nodeTargetId);
        if (!nodeSourceId.equals(nodeTargetId) && daoObject.isNodeExist(nodeSourceId) && daoObject.isNodeExist(nodeTargetId) &&
                !daoObject.isReferenceExist(nodeSourceId, nodeTargetId)) {
            return daoObject.createNodeReference(nodeSourceId, nodeTargetId);
        }
            logger.warning("Table \"Node_Reference\" has already node with same reference " + nodeSourceId + "-->" +
                    nodeTargetId + " Or node to refer to itself. All references have to be unique");


        return null;
    }

    public List<NodeReference> getRefenceByGraphName(String nodeName) {
        logger.info("Try get references By Name");
        if (daoObject.isReferenceExist(nodeName)) {
            return daoObject.readNodeReference(nodeName);
        } else {
            logger.warning("Not match node with name " + nodeName + " in table!");
        }
        return null;
    }

    public void updateNodeReference(String nodeSourceName, String initialNodeTargetName, String newNodeTargetName) {
        logger.info("Try update reference");
        if (daoObject.isReferenceExist(nodeSourceName, initialNodeTargetName)) {
            daoObject.updateNodeReference(nodeSourceName, initialNodeTargetName, newNodeTargetName);
        } else {
            logger.warning("Not match link like: " + nodeSourceName + " --> " + initialNodeTargetName);
        }
    }

    public void deleteNodeReference(String nodeSourceName, String nodeTargetName) {
        logger.info("Try delete reference");
        if (daoObject.isReferenceExist(nodeSourceName, nodeTargetName)) {
            daoObject.deleteNodeReference(nodeSourceName, nodeTargetName);
        } else {
            logger.warning("Not match link like: " + nodeSourceName + " --> " + nodeTargetName);
        }
    }

}
