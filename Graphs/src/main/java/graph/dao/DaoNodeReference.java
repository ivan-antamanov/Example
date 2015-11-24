package graph.dao;

import graph.domain.NodeReference;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by iantaman on 20.11.2015.
 */
public interface DaoNodeReference {

    public boolean isReferenceExist(String nodeSourceName);

    public int getSourceOrTargetId(String nodeSourceName) throws DataAccessException;

    public NodeReference createNodeReference(String nodeSourceName, String nodeTargetName);

    public List<NodeReference> readNodeReference(String nodeDataName);

    public NodeReference updateNodeReference(String nodeSourceName, String initialNodeTargetName, String newNodeTargetName);

    public NodeReference deleteNodeReference(String nodeSourceName, String nodeTargetName);

    public List<NodeReference> deleteAllNodesReferencesByName(String nodeSourceName);
}
