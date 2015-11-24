package graph.dao;

import graph.domain.Graph;
import graph.domain.NodeData;

import java.util.List;

/**
 * Created by iantaman on 20.11.2015.
 */
public interface DaoGraph {

    public boolean isGraphExist(String graphsName);

    public Graph createGraph(String graphsName);

    public Graph readGraph(String name);

    public Graph updateGraph(String newName, String initialName);

    public Graph deleteGraph(String graphsName);

    public List<Graph> allListGraph();

    public List<NodeData> allNodeGraphs();

}
