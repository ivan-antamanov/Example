package graph.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.util.Date;

/**
 * Created by iantaman on 06.11.2015.
 */
public class Graph {

    private Integer id;
    private String name;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatingDate;
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
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
    @JsonSerialize(using = DateSerializer.class)
    public Date getCreatingDate() {
        return creatingDate;
    }

    @JsonSerialize(using = DateSerializer.class)
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

//    @JsonSerialize(using = DateSerializer.class)
    public void setUpdatingDate(Date updatingDate) {
        this.updatingDate = updatingDate;
    }
}
