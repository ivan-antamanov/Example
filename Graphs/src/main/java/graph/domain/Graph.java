package graph.domain;

import java.util.Date;

/**
 * Created by iantaman on 06.11.2015.
 */
public class Graph {

    private Integer id;
    private String name;
    private Date creatingDate;
    private Date updatingDate;

    public Graph() {
    }

    public Graph(String name) {
        this.name = name;
        this.creatingDate = new Date();

    }

    @Override
    public String toString() {
        return "id = " + id + "\n" + "name = " + name + "\n" + "creatingDate = " + creatingDate + "\n" + "updatingDate = " + updatingDate;
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
}
