package graph.domain;

import java.util.Date;

/**
 * Created by iantaman on 06.11.2015.
 */
public class NodeData {

    private Integer id;
    private String name;
    private Date creatingDate;
    private Date updatingDate;
    private Integer graphId;

    public NodeData() {
    }

    public NodeData(String name) {
        this.name = name;
        creatingDate = new Date();
    }

    public NodeData(String name, Integer graphId) {

        this.name = name;
        this.graphId = graphId;
        creatingDate = new Date();
        updatingDate = new Date();
    }

    @Override
    public String toString() {
        return "creatingDate=" + creatingDate +
                "\nid=" + id +
                "\nname=" + name +
                "\nupdatingDate=" + updatingDate +
                "\ngraphId=" + graphId;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdatingDate() {
        return updatingDate;
    }

    public void setUpdatingDate(Date updatingDate) {
        this.updatingDate = updatingDate;
    }

    public Integer getGraphId() {
        return graphId;
    }

    public void setGraphId(Integer graphId) {
        this.graphId = graphId;
    }
}
