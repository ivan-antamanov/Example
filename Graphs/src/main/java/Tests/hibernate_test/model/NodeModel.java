package Tests.hibernate_test.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by iantaman on 26.11.2015.
 */
@Entity
@Table(name = "my_schema.node_data")
public class NodeModel extends Model {

    public NodeModel() {
    }

    public NodeModel(String name) {
        super(name);
    }

    public NodeModel(String name,GraphModel graphModel) {
        super(name);
        this.graphModel = graphModel;
        graphModel.setUpdate_time(new Date());
    }

    @ManyToOne
    @JoinColumn(name ="graphs_id")
    private GraphModel graphModel;

    public GraphModel getGraphModel() {
        return graphModel;
    }

    public void setGraphModel(GraphModel graphModel) {
        graphModel.setUpdate_time(new Date());
        this.graphModel = graphModel;
    }
}
