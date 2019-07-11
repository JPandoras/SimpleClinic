package app.springboot.simpleclinic.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pharmacy")
public class Pharmacy implements Serializable {

    @Id
    @OneToOne
    private UserLogin id;

    @Column(name = "name")
    private String name;

    public UserLogin getId() {
        return id;
    }

    public void setId(UserLogin id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
