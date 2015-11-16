package graph.model;

import graph.domain.NodeReference;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by iantaman on 10.11.2015.
 */
public class NodeReferenceRowMapper implements RowMapper<NodeReference> {
    @Override
    public NodeReference mapRow(ResultSet resultSet, int i) throws SQLException {
        NodeReference nodeReference = new NodeReference();
        nodeReference.setSource(resultSet.getInt("source"));
        nodeReference.setTarget(resultSet.getInt("target"));

        return nodeReference;
    }
}
