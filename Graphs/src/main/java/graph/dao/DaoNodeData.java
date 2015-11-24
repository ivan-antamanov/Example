package graph.dao;

import graph.domain.NodeData;
import graph.domain.NodeReference;

import java.util.List;

/**
 * Created by iantaman on 20.11.2015.
 */
public interface DaoNodeData {

    public boolean isNodeExist(String nodesName);
    public NodeData createNodeData(String nodeDataName);
    public NodeData readNodeData(String name);
    public NodeData updateNodeData(String initialName, String newName, String addNameGraph);
    public NodeData deleteNodeData(String nodeName);
    public List<NodeData> allNodeData();
    public List<NodeData> allReferToThisNode(String graphName, String nodeName);

}
