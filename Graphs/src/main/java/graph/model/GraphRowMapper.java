package graph.model;

import graph.domain.Graph;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by iantaman on 10.11.2015.
 */
public class GraphRowMapper implements RowMapper<Graph> {
    @Override
    public Graph mapRow(ResultSet resultSet, int i) throws SQLException {
        Graph graph = new Graph();
        graph.setId(resultSet.getInt("id"));
        graph.setName(resultSet.getString("name"));
        graph.setCreatingDate(resultSet.getDate("create_time"));
        graph.setUpdatingDate(resultSet.getDate("update_time"));

        return graph;
    }
}
