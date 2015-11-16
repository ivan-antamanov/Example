package graph.dao;

import graph.domain.Graph;
import graph.domain.NodeData;
import graph.domain.NodeReference;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by iantaman on 06.11.2015.
 */
public interface DaoObject {

    public Graph createGraph(String graphsName) throws SQLException;

    public Graph readGraph(String graphsName);

    public void updateGraph(String newName, String initialName);

    public void deleteGraph(String graphsName);
//CRUD methods for Graph

    public NodeData createNodeData(String nodeDataName);

    public NodeData readNodeData(String name);

    public void updateNodeData(String initialName, String newName, String addNameGraph);

    public void deleteNodeData(String nodeName);
//CRUD methods for NodeDate

    public NodeReference createNodeReference(String nodeSourceName, String nodeTargetName);

    public List<NodeReference> readNodeReference(String nodeDataName);

    public void updateNodeReference(String nodeSourceName, String initialNodeTargetName, String newNodeTargetName);

    public void deleteNodeReference(String nodeSourceName, String nodeTargetName);
//CRUD methods for NodeReference

}
