package Tests.hibernate_test.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by iantaman on 26.11.2015.
 */
//@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
//@Inheritance(strategy = InheritanceType.JOINED )
@MappedSuperclass
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private Date create_time;

    @Column
    private Date update_time;

    public Model() {
    }

    public Model(String name) {
        this.name = name;
        this.create_time = new Date();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
