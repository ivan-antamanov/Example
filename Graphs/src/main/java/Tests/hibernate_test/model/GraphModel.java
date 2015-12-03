package Tests.hibernate_test.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iantaman on 26.11.2015.
 */
@Entity
@Table(name = "my_schema.graphs")
public class GraphModel extends Model {

    public GraphModel() {
    }

    public GraphModel(String name) {
        super(name);
    }

    @OneToMany(mappedBy = "graphModel")
    private Set<NodeModel> nodeModels = new HashSet<>();

    public Set<NodeModel> getNodeModels() {
        return nodeModels;
    }

    public void setNodeModels(Set<NodeModel> nodeModels) {
        this.nodeModels = nodeModels;
    }
}
