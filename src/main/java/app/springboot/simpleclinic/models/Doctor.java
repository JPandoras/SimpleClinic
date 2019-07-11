package app.springboot.simpleclinic.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

    @Id
    @OneToOne
    private UserLogin id;

    @Column(name = "name")
    private String name;

    @Column(name = "availability")
    private String availability;

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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
