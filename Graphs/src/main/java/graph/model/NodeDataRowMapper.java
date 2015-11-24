package graph.model;

import graph.domain.NodeData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by iantaman on 10.11.2015.
 */
public class NodeDataRowMapper implements RowMapper<NodeData> {

    @Override
    public NodeData mapRow(ResultSet resultSet, int i) throws SQLException {
        NodeData nodeData = new NodeData();
        nodeData.setId(resultSet.getInt("id"));
        nodeData.setName(resultSet.getString("name"));
        nodeData.setCreatingDate(resultSet.getDate("create_time"));
        nodeData.setUpdatingDate(resultSet.getDate("update_time"));
        nodeData.setGraphId(resultSet.getInt("graphs_id"));

        return nodeData;
    }
}
