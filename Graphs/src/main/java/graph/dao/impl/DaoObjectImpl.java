package graph.dao.impl;

import graph.domain.DBfactory;
import graph.dao.DaoObject;
import graph.domain.Graph;
import graph.domain.NodeData;
import graph.domain.NodeReference;
import graph.model.GraphRowMapper;
import graph.model.NodeDataRowMapper;
import graph.model.NodeReferenceRowMapper;
import org.springframework.dao.DataAccessException;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by iantaman on 09.11.2015.
 */
public class DaoObjectImpl implements DaoObject {

    Logger logger = Logger.getLogger(DaoObject.class.getName());

    public boolean isGraphExist(String graphsName) {
        String sql = "SELECT count(*) FROM my_schema.graphs WHERE name = ?";
        int count = DBfactory.getJdbcTemplate().queryForObject(sql, new Object[]{graphsName}, Integer.class);

        return count > 0;
    }

    @Override
    public Graph createGraph(String graphsName) {
        Graph graph = new Graph(graphsName);
        DBfactory.getJdbcTemplate().update("INSERT INTO my_schema.graphs (name, create_time) values(?,?)",
                graph.getName(), graph.getCreatingDate());
        logger.info("Graph has been successful created: " + graph.toString());

        return graph;
    }

    @Override
    public Graph readGraph(String name) {
        String sql = "SELECT * FROM my_schema.graphs WHERE name = ?";
        Graph graph = (Graph) DBfactory.getJdbcTemplate().queryForObject(sql, new Object[]{name}, new GraphRowMapper());
        logger.info("Graph has been read: " + graph.toString());
        return graph;
    }

    @Override
    public void updateGraph(String newName, String initialName) {
        DBfactory.getJdbcTemplate().
                update("UPDATE my_schema.graphs SET name = ?, update_time = ? WHERE name = ?",
                        newName, new Date(), initialName);
        logger.info("Graph has been successful updated: " + newName + "has renamed to" + initialName);
    }

    @Override
    public void deleteGraph(String graphsName) {
        int graphId = DBfactory.getJdbcTemplate().
                queryForObject("SELECT id FROM my_schema.graphs WHERE name = ?", Integer.class, graphsName);
        DBfactory.getJdbcTemplate().
                update("DELETE FROM my_schema.node_reference WHERE " +
                                "source IN (SELECT id FROM my_schema.node_data WHERE graphs_id = ?) OR" +
                                " target IN (SELECT id FROM my_schema.node_data WHERE graphs_id = ?)",
                        graphId);
        DBfactory.getJdbcTemplate().update("DELETE FROM my_schema.node_data WHERE graphs_id = ?", graphId);
        DBfactory.getJdbcTemplate().update("DELETE FROM my_schema.graphs WHERE NAME = ?", graphsName);
        logger.info("Graph " + graphsName + " has been deleted:");

    }
// graphs daoImpl

    public boolean isNodeExist(String nodesName) {
        String sql = "SELECT count(*) FROM my_schema.node_data WHERE name = ?";
        int count = DBfactory.getJdbcTemplate().queryForObject(sql, new Object[]{nodesName}, Integer.class);

        return count > 0;
    }

    @Override
    public NodeData createNodeData(String nodeDataName) {
        NodeData nodeData = new NodeData(nodeDataName);
        DBfactory.getJdbcTemplate().
                update("INSERT INTO my_schema.node_data (name, create_time) values(?,?)",
                        nodeData.getName(), nodeData.getCreatingDate());
        logger.info("NodeData has been successful created: " + nodeData.toString());
        return nodeData;
    }


    @Override
    public NodeData readNodeData(String name) {
        String sql = "SELECT * FROM my_schema.node_data WHERE name = ?";
        NodeData nodeData = (NodeData) DBfactory.getJdbcTemplate().queryForObject(
                sql, new Object[]{name}, new NodeDataRowMapper());
        logger.info("NodeData has been read: " + nodeData.toString());
        return nodeData;
    }

    @Override
    public void updateNodeData(String initialName, String newName, String addNameGraph) {
        Graph graph = readGraph(addNameGraph);
        DBfactory.getJdbcTemplate().
                update("UPDATE my_schema.node_data SET name = ?, update_time = ?, graphs_id = ? WHERE name =?",
                        newName, new Date(), graph.getId(), initialName);
        logger.info("NodeData has been successful updated: " + newName +
                "has renamed to" + initialName + "and add to graph:" + addNameGraph);
    }

    @Override
    public void deleteNodeData(String nodeName) {
        deleteAllNodesReferencesByName(nodeName);
        DBfactory.getJdbcTemplate().update("DELETE FROM my_schema.node_data WHERE NAME = ?", nodeName);
        logger.info("NodeData: " + nodeName + " has been deleted:");

    }
//  nodeData daoImpl

    public boolean isReferenceExist(String nodeSourceName, String nodeTargetName) {
        int sourceId = getSourceOrTargetId(nodeSourceName);
        int targetId = getSourceOrTargetId(nodeTargetName);
        String sql = "SELECT count(*) FROM my_schema.node_reference WHERE source = ? AND target = ?";
        int count = DBfactory.getJdbcTemplate().queryForObject(sql, Integer.class, sourceId, targetId);

        return count > 0;
    }

    public boolean isReferenceExist(String nodeSourceName) {
        int sourceId = getSourceOrTargetId(nodeSourceName);
        String sql = " SELECT count(*) FROM my_schema.node_reference WHERE source = ?";
        int count = DBfactory.getJdbcTemplate().queryForObject(sql, Integer.class, sourceId);

        return count > 0;
    }

    public int getSourceOrTargetId(String nodeSourceName) throws DataAccessException {
        int sourceId = DBfactory.getJdbcTemplate().
                queryForObject("SELECT id FROM my_schema.node_data WHERE name = ?", Integer.class, nodeSourceName);
        return sourceId;
    }

    @Override
    public NodeReference createNodeReference(String nodeSourceName, String nodeTargetName) {
        int sourceId = getSourceOrTargetId(nodeSourceName);
        int targetId = getSourceOrTargetId(nodeTargetName);
        DBfactory.getJdbcTemplate().
                update("INSERT INTO my_schema.node_reference (source, target) values (?,?)", sourceId, targetId);
        NodeReference nodeReference = new NodeReference(sourceId, targetId);
        logger.info("NodeReference has been created:" + nodeSourceName + "-->" + nodeTargetName);
        return nodeReference;
    }

    @Override
    public List<NodeReference> readNodeReference(String nodeDataName) {
        int sourceId = DBfactory.getJdbcTemplate().
                queryForObject("SELECT id FROM my_schema.node_data WHERE name = ?", Integer.class, nodeDataName);

        List<NodeReference> listOfReferences = DBfactory.
                getJdbcTemplate().query("SELECT target, source FROM my_schema.node_reference WHERE source = ? ",
                new Object[]{sourceId}, new NodeReferenceRowMapper());
        logger.info("NodeReference has been read");
        return listOfReferences;
    }

    @Override
    public void updateNodeReference(String nodeSourceName, String initialNodeTargetName, String newNodeTargetName) {
        int sourceId = DBfactory.getJdbcTemplate().
                queryForObject("SELECT id FROM my_schema.node_data WHERE name = ?", Integer.class, nodeSourceName);
        int targetId = DBfactory.getJdbcTemplate().
                queryForObject("SELECT id FROM my_schema.node_data WHERE name = ?", Integer.class, initialNodeTargetName);
        int newTargetId = DBfactory.getJdbcTemplate().
                queryForObject("SELECT id FROM my_schema.node_data WHERE name = ?", Integer.class, newNodeTargetName);

        DBfactory.getJdbcTemplate().
                update("UPDATE my_schema.node_reference SET target =? WHERE source = ? AND target = ?",
                        newTargetId, sourceId, targetId);
        logger.info("NodeReference " + nodeSourceName + " has been updated:" + initialNodeTargetName +
                " refer to " + newNodeTargetName);
    }

    @Override
    public void deleteNodeReference(String nodeSourceName, String nodeTargetName) {
        int sourceId = getSourceOrTargetId(nodeSourceName);
        int targetId = getSourceOrTargetId(nodeTargetName);
        DBfactory.getJdbcTemplate().
                update("DELETE FROM my_schema.node_reference WHERE source = ? AND target = ?", sourceId, targetId);
        logger.info("NodeReference " + nodeSourceName + "-->" + nodeTargetName + " has been deleted");
    }

    private void deleteAllNodesReferencesByName(String nodeSourceName) {
        int sourceAndTargetId = getSourceOrTargetId(nodeSourceName);
        DBfactory.getJdbcTemplate().
                update("DELETE FROM my_schema.node_reference WHERE source = ? OR target = ?",
                        sourceAndTargetId, sourceAndTargetId);

    }

}
